package ro.fasttrack.gymnasticCompetition.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import ro.fasttrack.gymnasticCompetition.enums.EventType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreRankingDTO {
    private String athleteName;
    private String eventName;
    private double score;

    // Constructor used for transforming Object[] to ScoreRankingDTO
    public ScoreRankingDTO(Object[] fields) {
        this.athleteName = fields[0] + " " + fields[1];
        this.eventName = ((EventType) fields[2]).name();
        this.score = (Double) fields[3];
    }
}

