package ro.fasttrack.gymnasticCompetition.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import ro.fasttrack.gymnasticCompetition.entity.Event;
import ro.fasttrack.gymnasticCompetition.enums.EventType;


@Getter
@Setter
public class ScoreDTO {

    @NotNull(message = "Athlete ID cannot be null")
    private Long athleteId;

    @NotNull(message = "Event name cannot be null")
    @Size(min = 1, message = "Event name cannot be empty")
    private String eventName;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 100, message = "Score cannot be higher than 100")
    private double score;


}
