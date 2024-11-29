package local.epul4a.photoshare.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "imageFile")
public class ImageInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image", nullable = false)
    private Integer id;

    @Column(name = "upload_date")
    private Instant uploadDate;

    @Column(name = "image_filename")
    private String imageFilename;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "description")
    private String description;

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

    public Instant getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Instant uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageInfoEntity id(Integer id) {
        setId(id);
        return this;
    }

    public ImageInfoEntity uploadDate(Instant uploadDate) {
        setUploadDate(uploadDate);
        return this;
    }

    public ImageInfoEntity imageFilename(String imageFilename) {
        setImageFilename(imageFilename);
        return this;
    }

    public ImageInfoEntity imagePath(String imagePath) {
        setImagePath(imagePath);
        return this;
    }

    public ImageInfoEntity description(String description) {
        setDescription(description);
        return this;
    }
}
