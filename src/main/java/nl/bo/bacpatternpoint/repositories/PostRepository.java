package nl.bo.bacpatternpoint.repositories;
import nl.bo.bacpatternpoint.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
