package ro.fasttrack.gymnasticCompetition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fasttrack.gymnasticCompetition.dto.EventRankingDTO;
import ro.fasttrack.gymnasticCompetition.dto.ScoreRankingDTO;
import ro.fasttrack.gymnasticCompetition.entity.Athlete;
import ro.fasttrack.gymnasticCompetition.entity.Score;
import ro.fasttrack.gymnasticCompetition.enums.EventType;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
//    List<Score> findByAthleteAndEventName(Athlete athlete, EventType eventName);
    List<Score> findByAthleteId(Long athleteId);

    @Query("SELECT a.firstName, a.lastName, e.name, s.score " +
            "FROM Score s JOIN s.athlete a JOIN s.event e " +
            "ORDER BY s.score DESC")
    List<Object[]> findScoreRankings();

    @Query("SELECT new ro.fasttrack.gymnasticCompetition.dto.EventRankingDTO(" +
            "concat(a.firstName, ' ', a.lastName), " +
            "e.name, " +
            "s.score) " +
            "FROM Score s JOIN s.athlete a JOIN s.event e " +
            "WHERE e.name =:eventType " +
            "ORDER BY s.score DESC")
    List<EventRankingDTO> findRankingsForEvent(@Param("eventType") EventType eventType);
}
