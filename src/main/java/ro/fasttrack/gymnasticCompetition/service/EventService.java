package ro.fasttrack.gymnasticCompetition.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrack.gymnasticCompetition.entity.Event;
import ro.fasttrack.gymnasticCompetition.enums.EventType;
import ro.fasttrack.gymnasticCompetition.repository.EventRepository;

import java.util.List;

import static ro.fasttrack.gymnasticCompetition.enums.EventType.*;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

//    @PostConstruct
//    public void initEvents() {
//        eventRepository.saveAll(List.of(
//                new Event(BEAM),
//                new Event(RINGS),
//                new Event(FLOOR_EXERCISE),
//                new Event(UNEVEN_BARS)
//        ));
//    }
}
