package subway.domain;

import static subway.util.Constants.MIN_LINE_NAME_LENGTH;
import static subway.util.ExceptionMessage.ALREADY_REGISTERED_IN_LINE;
import static subway.util.ExceptionMessage.INVALID_STATION_NAME_LENGTH;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final String name;
    private final List<Station> sections = new ArrayList<>();

    public Line(String name) {
        validateLine(name);
        this.name = name;
    }

    private void validateLine(String name) {
        if (name.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void addSection(Station station) {
        if (sections.contains(station)) {
            throw new IllegalArgumentException(ALREADY_REGISTERED_IN_LINE.getMessage());
        }
        this.sections.add(station);
    }

    public boolean hasStation(Station station) {
        return sections.contains(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name) && Objects.equals(sections, line.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sections);
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", sections=" + sections +
                '}';
    }
}
