package ro.fasttrack.gymnasticCompetition.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;



    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    private double score; // Score from 1 to 10

    public Score(Athlete athlete, Event event, double score) {
        this.athlete = athlete;
        this.event = event;
        this.score = score;
    }


}