package subway.domain.command;

import java.util.Arrays;
import subway.util.ExceptionMessage;

public enum StationCommand {
    STATION_REGISTER("1"),
    STATION_DELETE("2"),
    STATION_SEARCH("3"),
    GO_BACK("B");

    private final String command;

    StationCommand(String command) {
        this.command = command;
    }

    public static StationCommand from(String command) {
        return Arrays.stream(StationCommand.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_COMMAND.getMessage()));
    }

}
