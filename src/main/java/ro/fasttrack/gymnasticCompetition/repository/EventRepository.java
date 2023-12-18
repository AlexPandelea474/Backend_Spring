package ro.fasttrack.gymnasticCompetition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrack.gymnasticCompetition.entity.Event;
import ro.fasttrack.gymnasticCompetition.enums.EventType;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(EventType name);
}