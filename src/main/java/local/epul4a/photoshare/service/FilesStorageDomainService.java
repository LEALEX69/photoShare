package local.epul4a.photoshare.service;

import local.epul4a.photoshare.dto.ImageInfoDTO;
import local.epul4a.photoshare.mapper.ImageInfoMapper;
import local.epul4a.photoshare.model.ImageInfoEntity;
import local.epul4a.photoshare.model.jpa.ImageInfoEntityJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FilesStorageDomainService implements FilesService {

    private final Path root = Paths.get("./uploads");

    @Autowired
    private ImageInfoEntityJpaRepository imageInfoEntityJpaRepository;

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Impossible d'initialiser le dossier pour le téléchargement !");
        }
    }

    @Override
    public void save(ImageInfoDTO imageInfoDTO) {
        try {
            MultipartFile file = imageInfoDTO.getMultipartFile();
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            ImageInfoEntity toSaveInDb = ImageInfoMapper.toEntityFromDTO(imageInfoDTO);
            imageInfoEntityJpaRepository.save(toSaveInDb);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Un fichier de ce nom existe déjà.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Impossible de lire le fichier !");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erreur : " + e.getMessage());
        }
    }

    @Override
    public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Erreur : " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Impossible de charger les fichiers !");
        }
    }
}
