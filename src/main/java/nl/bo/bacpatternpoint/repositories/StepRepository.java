package nl.bo.bacpatternpoint.repositories;

import nl.bo.bacpatternpoint.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository <Step, Long> {
}
