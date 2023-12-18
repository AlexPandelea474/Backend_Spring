package ro.fasttrack.gymnasticCompetition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.fasttrack.gymnasticCompetition.enums.EventType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @Enumerated(EnumType.STRING)
    private EventType name;

}