package subway.domain;

import static subway.util.Constants.MIN_STATION_NAME_LENGTH;
import static subway.util.ExceptionMessage.INVALID_STATION_NAME_LENGTH;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        validateStation(name);
        this.name = name;
    }

    private void validateStation(String name) {
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String stationName) {
        return this.name.equals(stationName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }
}
