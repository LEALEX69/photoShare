package local.epul4a.photoshare.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesService {

    void init();

    void save(MultipartFile file);

    Resource load(String filename);

    boolean delete(String filename);

    void deleteAll();

    Stream<Path> loadAll();
}
