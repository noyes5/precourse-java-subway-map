package subway.domain.command;

import java.util.Arrays;
import subway.util.ExceptionMessage;

public enum MainCommand {
    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    PRINT_SUBWAY_ROUTE("4"),
    APPLICATION_EXIT("Q");

    private final String command;

    MainCommand(String command) {
        this.command = command;
    }

    public boolean isPlayable() {
        return this != APPLICATION_EXIT;
    }

    public static MainCommand from(String command) {
        return Arrays.stream(MainCommand.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_COMMAND.getMessage()));
    }
}
