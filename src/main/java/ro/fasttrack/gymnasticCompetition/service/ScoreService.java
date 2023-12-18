package ro.fasttrack.gymnasticCompetition.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fasttrack.gymnasticCompetition.dto.EventRankingDTO;
import ro.fasttrack.gymnasticCompetition.dto.ScoreDTO;
import ro.fasttrack.gymnasticCompetition.dto.ScoreRankingDTO;
import ro.fasttrack.gymnasticCompetition.entity.Athlete;
import ro.fasttrack.gymnasticCompetition.entity.Event;
import ro.fasttrack.gymnasticCompetition.entity.Score;
import ro.fasttrack.gymnasticCompetition.enums.EventType;
import ro.fasttrack.gymnasticCompetition.repository.AthleteRepository;
import ro.fasttrack.gymnasticCompetition.repository.EventRepository;
import ro.fasttrack.gymnasticCompetition.repository.ScoreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final AthleteRepository athleteRepository;
    private final EventRepository eventRepository;


    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Score addScore(ScoreDTO scoreDTO) {
        Athlete athlete = athleteRepository.findById(scoreDTO.getAthleteId())
                .orElseThrow(() -> new EntityNotFoundException("Athlete not found"));
        EventType eventType = EventType.of(scoreDTO.getEventName());

        Event event = eventRepository.findByName(eventType)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        Score score = new Score();
        score.setAthlete(athlete);
        score.setEvent(event);
        score.setScore(scoreDTO.getScore());

        return scoreRepository.save(score);
    }

    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    public Score updateScore(Long id, Score updatedScore) {
        return scoreRepository.findById(id)
                .map(existingScore -> {
                    existingScore.setScore(updatedScore.getScore());
                    return scoreRepository.save(existingScore);
                })
                .orElse(null); // Or handle differently
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

    public List<String> findScoresByAthlete(Long athleteId) {
        return scoreRepository.findByAthleteId(athleteId).stream()
                .map(score -> "Event: " + score.getEvent().getName() + ", Score: " + score.getScore())
                .collect(Collectors.toList());
    }

    public List<ScoreRankingDTO> getScoreRankings() {
        List<Object[]> results = scoreRepository.findScoreRankings();
        return results.stream()
                .map(result -> new ScoreRankingDTO(
                        result[0] + " " + result[1], // athleteName
                        ((EventType) result[2]).name(), // eventName
                        (Double) result[3] // score
                ))
                .collect(Collectors.toList());
    }
    public List<EventRankingDTO> getRankingsForEvent(EventType eventType) {
        return scoreRepository.findRankingsForEvent(eventType);
    }

}