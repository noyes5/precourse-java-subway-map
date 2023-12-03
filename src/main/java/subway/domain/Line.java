package subway.domain;

import static subway.util.ExceptionMessage.DUPLICATED_STATION_IN_LINE;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(Station station) {
        if (sections.contains(station)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_IN_LINE.getMessage());
        }
        this.sections.add(station);
    }
}
