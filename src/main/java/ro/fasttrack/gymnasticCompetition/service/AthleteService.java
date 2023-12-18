package ro.fasttrack.gymnasticCompetition.service;

import org.springframework.stereotype.Service;
import ro.fasttrack.gymnasticCompetition.entity.Athlete;
import ro.fasttrack.gymnasticCompetition.repository.AthleteRepository;

import java.util.List;

@Service
public class AthleteService {
    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }
    public Athlete addAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    // Method to get an athlete by ID
    public Athlete getAthleteById(Long id) {
        return athleteRepository.findById(id).orElse(null);
    }

    // Method to update an existing athlete
    public Athlete updateAthlete(Long id, Athlete athlete) {
        return athleteRepository.findById(id)
                .map(existingAthlete -> {
                    if (athlete.getFirstName() != null) existingAthlete.setFirstName(athlete.getFirstName());
                    if (athlete.getLastName() != null) existingAthlete.setLastName(athlete.getLastName());
                    if (athlete.getGender() != null) existingAthlete.setGender(athlete.getGender());
                    if (athlete.getAge() != 0) existingAthlete.setAge(athlete.getAge());
                    return athleteRepository.save(existingAthlete);
                })
                .orElseGet(() -> {
                    athlete.setId(id);
                    return athleteRepository.save(athlete);
                });
    }

    // Method to delete an athlete by ID
    public void deleteAthlete(Long id) {
        athleteRepository.deleteById(id);
    }

}