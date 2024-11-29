package local.epul4a.photoshare.mapper;

import local.epul4a.photoshare.dto.ImageInfoDTO;
import local.epul4a.photoshare.model.ImageInfoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

public class ImageInfoMapper {

    public static final String ROOT_PATH_STRING = "./uploads";

    private ImageInfoMapper() {}

    public static ImageInfoEntity toEntityFromDTO(ImageInfoDTO imageInfoDTO) {
        MultipartFile file = imageInfoDTO.getMultipartFile();
        String pathAsString = ROOT_PATH_STRING + "/" + file.getOriginalFilename();
        return new ImageInfoEntity()
            .uploadDate(Instant.now())
            .imageFilename(file.getOriginalFilename())
            .imagePath(pathAsString)
            .description(imageInfoDTO.getDescription());
    }
}
