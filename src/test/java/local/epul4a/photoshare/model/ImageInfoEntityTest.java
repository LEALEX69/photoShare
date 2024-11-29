package local.epul4a.photoshare.model;

import local.epul4a.photoshare.fixture.ImageInfoEntityFixture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ImageInfoEntityTest {

    @Test
    void shouldBuild() {
        ImageInfoEntity result = ImageInfoEntityFixture.imageInfo();

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(ImageInfoEntityFixture.IMAGE_INFO_ID);
        assertThat(result.getUploadDate().truncatedTo(ChronoUnit.DAYS))
            .isEqualTo(ImageInfoEntityFixture.IMAGE_INFO_UPLOAD_DATE.truncatedTo(ChronoUnit.DAYS));
        assertThat(result.getImageFilename()).isEqualTo(ImageInfoEntityFixture.IMAGE_INFO_FILE_NAME);
        assertThat(result.getImagePath()).isEqualTo(ImageInfoEntityFixture.IMAGE_INFO_IMAGE_PATH);
        assertThat(result.getDescription()).isEqualTo(ImageInfoEntityFixture.IMAGE_INFO_DESCRIPTION);
    }
}