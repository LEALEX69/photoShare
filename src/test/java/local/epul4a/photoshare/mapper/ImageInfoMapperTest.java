package local.epul4a.photoshare.mapper;

import local.epul4a.photoshare.dto.ImageInfoDTO;
import local.epul4a.photoshare.fixture.ImageInfoDTOFixture;
import local.epul4a.photoshare.model.ImageInfoEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

class ImageInfoMapperTest {

    @Test
    void shouldToEntityFromDTO() {
        // Given
        ImageInfoDTO imageInfoDTO = ImageInfoDTOFixture.imageInfoDTO();
        // When
        ImageInfoEntity result = ImageInfoMapper.toEntityFromDTO(imageInfoDTO);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isNull();
        assertThat(result.getDescription()).isEqualTo(ImageInfoDTOFixture.IMAGE_INFO_DTO_DESCRIPTION);
        assertThat(result.getImagePath()).isEqualTo(
            ImageInfoMapper.ROOT_PATH_STRING + "/" + ImageInfoDTOFixture.IMAGE_INFO_DTO_FILE.getOriginalFilename()
        );
        assertThat(result.getUploadDate().truncatedTo(ChronoUnit.DAYS)).isEqualTo(Instant.now().truncatedTo(ChronoUnit.DAYS));
    }
}