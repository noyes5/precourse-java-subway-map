package subway.domain.command;

import java.util.Arrays;
import subway.util.ExceptionMessage;

public enum LineCommand {
    LINE_REGISTER("1"),
    LINE_DELETE("2"),
    LINE_SEARCH("3"),
    GO_BACK("B");

    private final String command;

    LineCommand(String command) {
        this.command = command;
    }

    public static LineCommand from(String command) {
        return Arrays.stream(LineCommand.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_COMMAND.getMessage()));
    }
}
