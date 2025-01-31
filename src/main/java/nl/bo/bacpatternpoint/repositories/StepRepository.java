package nl.bo.bacpatternpoint.repositories;

import nl.bo.bacpatternpoint.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository <Step, Long> {
}
