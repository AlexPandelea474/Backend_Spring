package ro.fasttrack.gymnasticCompetition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrack.gymnasticCompetition.entity.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    // Basic CRUD methods are inherited
}
