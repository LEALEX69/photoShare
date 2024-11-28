package local.epul4a.photoshare.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ImageInfoEntityJpaRepositoryIT {

    @Autowired
    ImageInfoEntityJpaRepository imageInfoEntityJpaRepository;

    @Test
    void shouldReturn() {
        List<ImageInfoEntity> result = imageInfoEntityJpaRepository.findAll();

        assertThat(result).isNotNull().isEmpty();
    }
}