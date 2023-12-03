package subway.domain;

import static subway.util.ExceptionMessage.DUPLICATED_STATION_MESSAGE;
import static subway.util.ExceptionMessage.INVALID_STATION_NAME;
import static subway.util.ExceptionMessage.STATION_DELETE_NOT_ALLOWED;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_MESSAGE.getMessage());
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        Station stationToDelete = getStation(name);

        for (Line line : LineRepository.lines()) {
            if (line.hasStation(stationToDelete)) {
                throw new IllegalArgumentException(STATION_DELETE_NOT_ALLOWED.getMessage());
            }
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station getStation(String stationName) {
        return stations.stream()
                .filter(station -> station.isEqualName(stationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_STATION_NAME.getMessage()));
    }
}
