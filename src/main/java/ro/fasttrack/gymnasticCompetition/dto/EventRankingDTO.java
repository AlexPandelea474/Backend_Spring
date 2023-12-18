package ro.fasttrack.gymnasticCompetition.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.fasttrack.gymnasticCompetition.enums.EventType;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class EventRankingDTO {
    private String athleteName;
    private EventType eventName;
    private double score;

    // Make sure this constructor exists
    public EventRankingDTO(String athleteName, EventType eventName, double score) {
        this.athleteName = athleteName;
        this.eventName = eventName;
        this.score = score;
    }
    }
