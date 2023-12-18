package ro.fasttrack.gymnasticCompetition.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrack.gymnasticCompetition.entity.Score;
import ro.fasttrack.gymnasticCompetition.service.AthleteService;
import ro.fasttrack.gymnasticCompetition.entity.Athlete;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/athletes")
public class AthleteController {
    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public List<Athlete> getAllAthletes() {
        return athleteService.getAllAthletes();
    }

    // Endpoint to add a new athlete
    @PostMapping
    public ResponseEntity<Athlete> addAthlete(@Valid @RequestBody Athlete athlete) {
        Athlete newAthlete = athleteService.addAthlete(athlete);
        return new ResponseEntity<>(newAthlete, HttpStatus.CREATED);
    }

    // Endpoint to retrieve an athlete by ID
    @GetMapping("/{id}")
    public Athlete getAthleteById(@PathVariable Long id) {
        return athleteService.getAthleteById(id);
    }

    // Endpoint to update an existing athlete
    @PutMapping("/{id}")
    public Athlete updateAthlete(@PathVariable Long id,@Valid @RequestBody Athlete athlete) {
        return athleteService.updateAthlete(id, athlete);
    }

    // Endpoint to delete an athlete
    @DeleteMapping("/{id}")
    public void deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
    }


}