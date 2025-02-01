package nl.bo.bacpatternpoint.repositories;

import nl.bo.bacpatternpoint.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
