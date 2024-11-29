package local.epul4a.photoshare.dto;

import local.epul4a.photoshare.fixture.ImageInfoDTOFixture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImageInfoDTOTest {

    @Test
    void shouldBuild() {
        ImageInfoDTO result = ImageInfoDTOFixture.imageInfoDTO();

        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(ImageInfoDTOFixture.imageInfoDTO());
    }
}