package local.epul4a.photoshare.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageInfoEntityJpaRepository extends JpaRepository<ImageInfoEntity, Integer> {

    @Override
    @Query(
        value= """
            select i.idImage as id,
                   i.description as description,
                   i.imagePath as imagePath,
                   i.uploadDate as uploadDate
            from image i
       """,
        nativeQuery = true
    )
    List<ImageInfoEntity> findAll();
}
