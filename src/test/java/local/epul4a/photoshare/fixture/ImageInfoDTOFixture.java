package local.epul4a.photoshare.fixture;

import local.epul4a.photoshare.dto.ImageInfoDTO;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class ImageInfoDTOFixture {

    public static final MultipartFile IMAGE_INFO_DTO_FILE = MultipartFileFixture.multipartFile();
    public static final String IMAGE_INFO_DTO_DESCRIPTION = "imageInfoDTODescription";

    private ImageInfoDTOFixture() {}

    public static ImageInfoDTO imageInfoDTO() {
        return new ImageInfoDTO()
            .multipartFile(IMAGE_INFO_DTO_FILE)
            .description(IMAGE_INFO_DTO_DESCRIPTION);
    }
}
