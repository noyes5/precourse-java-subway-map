package subway.domain;

import static subway.util.ExceptionMessage.DUPLICATION_LINE_MESSAGE;
import static subway.util.ExceptionMessage.INVALID_LINE_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        Line lineToRemove = getLine(name);
        return lines.remove(lineToRemove);
    }

    public static Line getLine(String lineName) {
        return lines.stream()
                .filter(line -> line.isEqualName(lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_LINE_NAME.getMessage()));
    }

}
