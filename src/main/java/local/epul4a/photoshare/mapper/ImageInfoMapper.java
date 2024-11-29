package local.epul4a.photoshare.mapper;

import local.epul4a.photoshare.model.ImageInfoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

public class ImageInfoMapper {

    public static final String ROOT_PATH_STRING = "./uploads";

    private ImageInfoMapper() {}

    public static ImageInfoEntity toEntityFromFile(MultipartFile multipartFile) {
        String pathAsString = ROOT_PATH_STRING + "/" + multipartFile.getOriginalFilename();
        return new ImageInfoEntity()
            .description(multipartFile.getContentType())
            .imagePath(pathAsString)
            .uploadDate(Instant.now());
    }
}
