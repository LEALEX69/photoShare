package local.epul4a.photoshare.model.jpa;

import local.epul4a.photoshare.model.ImageInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageInfoEntityJpaRepository extends JpaRepository<ImageInfoEntity, Integer> {

    @Override
    @Query(
        value= """
            select i.id_image as id,
                   i.upload_date as uploadDate,
                   i.image_filename as imageFilename,
                   i.image_path as imagePath,
                   i.description as description
            from image i
       """,
        nativeQuery = true
    )
    List<ImageInfoEntity> findAll();
}
