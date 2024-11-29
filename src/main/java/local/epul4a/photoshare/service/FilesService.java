package local.epul4a.photoshare.service;

import local.epul4a.photoshare.dto.ImageInfoDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesService {

    void init();

    void save(ImageInfoDTO imageInfoDTO);

    Resource load(String filename);

    boolean delete(String filename);

    void deleteAll();

    Stream<Path> loadAll();
}
