package local.epul4a.photoshare.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class ImageInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "uploadDate")
    private Instant uploadDate;

    public ImageInfoEntity() {}

    public ImageInfoEntity(String description, String imagePath, Instant uploadDate) {
        this.description = description;
        this.imagePath = imagePath;
        this.uploadDate = uploadDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Instant getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Instant uploadDate) {
        this.uploadDate = uploadDate;
    }

    public ImageInfoEntity id(Integer id) {
        setId(id);
        return this;
    }

    public ImageInfoEntity description(String description) {
        setDescription(description);
        return this;
    }

    public ImageInfoEntity imagePath(String imagePath) {
        setImagePath(imagePath);
        return this;
    }

    public ImageInfoEntity uploadDate(Instant uploadDate) {
        setUploadDate(uploadDate);
        return this;
    }
}
