package ro.fasttrack.gymnasticCompetition.enums;

import java.util.Arrays;

public enum EventType {
    BEAM,
    UNEVEN_BARS,
    FLOOR_EXERCISE,
    RINGS;

    public static EventType of(String name) {
        return Arrays.stream(EventType.values())
                .filter(eventType -> eventType.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Could not find event with name %s".formatted(name)));
    }
}