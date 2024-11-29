package local.epul4a.photoshare.mapper;

import local.epul4a.photoshare.fixture.MultipartFileFixture;
import local.epul4a.photoshare.model.ImageInfoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

class ImageInfoMapperTest {

    @Test
    void shouldToEntityFromFile() {
        // Given
        MultipartFile file = MultipartFileFixture.multipartFile();
        // When
        ImageInfoEntity result = ImageInfoMapper.toEntityFromFile(file);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isNull();
        assertThat(result.getDescription()).isEqualTo(file.getContentType());
        assertThat(result.getImagePath()).isEqualTo(ImageInfoMapper.ROOT_PATH_STRING + "/" + file.getOriginalFilename());
        assertThat(result.getUploadDate().truncatedTo(ChronoUnit.DAYS)).isEqualTo(Instant.now().truncatedTo(ChronoUnit.DAYS));
    }
}