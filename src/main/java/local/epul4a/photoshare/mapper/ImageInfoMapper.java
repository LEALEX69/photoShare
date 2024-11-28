package local.epul4a.photoshare.mapper;

import local.epul4a.photoshare.model.ImageInfoEntity;
import org.springframework.web.multipart.MultipartFile;

public class ImageInfoMapper {

    public ImageInfoMapper() {}

    public ImageInfoEntity toEntity(MultipartFile multipartFile) {
        return new ImageInfoEntity();
    }
}
