package local.epul4a.photoshare.fixture;

import local.epul4a.photoshare.model.ImageInfo;
import local.epul4a.photoshare.model.ImageInfoEntity;

import java.time.Instant;

public class ImageInfoEntityFixture {

    public static final Integer IMAGE_INFO_ID = 1;
    public static final String IMAGE_INFO_DESCRIPTION = "description";
    public static final String IMAGE_INFO_FILE_NAME = "fileName";
    public static final String IMAGE_INFO_IMAGE_PATH = "imagePath";
    public static final Instant IMAGE_INFO_UPLOAD_DATE = Instant.now();

    private ImageInfoEntityFixture() {}

    public static ImageInfoEntity imageInfo() {
        return new ImageInfoEntity()
            .id(IMAGE_INFO_ID)
            .uploadDate(IMAGE_INFO_UPLOAD_DATE)
            .imageFilename(IMAGE_INFO_FILE_NAME)
            .imagePath(IMAGE_INFO_IMAGE_PATH)
            .description(IMAGE_INFO_DESCRIPTION);
    }
}
