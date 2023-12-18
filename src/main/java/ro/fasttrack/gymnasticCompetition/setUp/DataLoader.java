package ro.fasttrack.gymnasticCompetition.setUp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrack.gymnasticCompetition.entity.Athlete;
import ro.fasttrack.gymnasticCompetition.entity.Event;
import ro.fasttrack.gymnasticCompetition.entity.Score;
import ro.fasttrack.gymnasticCompetition.repository.AthleteRepository;
import ro.fasttrack.gymnasticCompetition.repository.EventRepository;
import ro.fasttrack.gymnasticCompetition.repository.ScoreRepository;

import java.util.List;

import static ro.fasttrack.gymnasticCompetition.enums.EventType.*;
import static ro.fasttrack.gymnasticCompetition.enums.EventType.UNEVEN_BARS;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner{
    private final EventRepository eventRepository;
    private final AthleteRepository athleteRepository;
    private final ScoreRepository scoreRepository;

    @Override
    public void run(String... args) throws Exception {
        eventRepository.saveAll(List.of(
                new Event(BEAM),
                new Event(RINGS),
                new Event(FLOOR_EXERCISE),
                new Event(UNEVEN_BARS)
        ));
        athleteRepository.saveAll(List.of(
                new Athlete("Alex", "Pandelea", "male", 26),
                new Athlete("Adam", "Pandelescu", "female", 36),
                new Athlete("Mark", "Cool", "male", 19),
                new Athlete("Mia", "Roberts", "female", 22),
                new Athlete("Ethan", "Johnson", "male", 28),
                new Athlete("Olivia", "Brown", "female", 24),
                new Athlete("Noah", "Davis", "male", 30),
                new Athlete("Emma", "Miller", "female", 27),
                new Athlete("Liam", "Wilson", "male", 25),
                new Athlete("Sophia", "Taylor", "female", 23)

        ));


    }
}
