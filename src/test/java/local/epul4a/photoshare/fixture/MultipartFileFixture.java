package local.epul4a.photoshare.fixture;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileFixture {

    private MultipartFileFixture() {}

    public static MultipartFile multipartFile() {
        return new MockMultipartFile(
            "file",
            "multipart.txt",
            "text/plain",
            "defaultMultipartFile".getBytes());
    }
}
