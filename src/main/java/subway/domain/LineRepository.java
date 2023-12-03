package subway.domain;

import static subway.util.ExceptionMessage.DUPLICATION_LINE_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (containsLineByName(line.getName())) {
            throw new IllegalArgumentException(DUPLICATION_LINE_MESSAGE.getMessage());
        }
        lines.add(line);
    }

    private static boolean containsLineByName(String name) {
        return lines.stream().anyMatch(line -> line.getName().equals(name));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }


}
