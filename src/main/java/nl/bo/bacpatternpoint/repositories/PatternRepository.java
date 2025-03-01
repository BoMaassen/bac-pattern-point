package nl.bo.bacpatternpoint.repositories;

import nl.bo.bacpatternpoint.models.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatternRepository extends JpaRepository<Pattern, Long> {
}
