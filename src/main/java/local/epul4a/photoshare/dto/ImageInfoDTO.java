package local.epul4a.photoshare.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageInfoDTO {

    private MultipartFile multipartFile;
    private String description;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageInfoDTO multipartFile(MultipartFile multipartFile) {
        setMultipartFile(multipartFile);
        return this;
    }

    public ImageInfoDTO description(String description) {
        setDescription(description);
        return this;
    }
}
