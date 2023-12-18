package ro.fasttrack.gymnasticCompetition.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrack.gymnasticCompetition.dto.EventRankingDTO;
import ro.fasttrack.gymnasticCompetition.dto.ScoreDTO;
import ro.fasttrack.gymnasticCompetition.dto.ScoreRankingDTO;
import ro.fasttrack.gymnasticCompetition.entity.Athlete;
import ro.fasttrack.gymnasticCompetition.entity.Score;
import ro.fasttrack.gymnasticCompetition.enums.EventType;
import ro.fasttrack.gymnasticCompetition.service.ScoreService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    // Endpoint to retrieve an athlete by ID
    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable Long id) {
        return scoreService.getScoreById(id);
    }

    // POST endpoint for creating a new score
    @PostMapping
    public ResponseEntity<Score> addScore(@Valid @RequestBody ScoreDTO scoreDTO) {
        Score newScore = scoreService.addScore(scoreDTO);
        return new ResponseEntity<>(newScore, HttpStatus.CREATED);

    }
    // Endpoint to update an existing athlete
    @PutMapping("/{id}")
    public Score updateScore(@PathVariable Long id,@Valid @RequestBody Score updatedScore) {
        return scoreService.updateScore(id, updatedScore);
    }

    // Endpoint to delete an athlete
    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
    }

    @GetMapping("/rankings")
    public List<ScoreRankingDTO> getScoreRankings() {
        return scoreService.getScoreRankings();
    }

    @GetMapping("/rankings/{eventType}")
    public List<EventRankingDTO> getRankingsForEvent(@PathVariable EventType eventType) {
        return scoreService.getRankingsForEvent(eventType);
    }
}