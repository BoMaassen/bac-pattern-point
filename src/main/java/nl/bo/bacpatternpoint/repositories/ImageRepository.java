package nl.bo.bacpatternpoint.repositories;
import nl.bo.bacpatternpoint.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
