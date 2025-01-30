package nl.bo.bacpatternpoint.repositories;

import nl.bo.bacpatternpoint.models.Abbreviation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbbreviationRepository extends JpaRepository<Abbreviation, Long> {
}
