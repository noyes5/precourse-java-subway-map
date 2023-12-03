package subway.domain.command;

import java.util.Arrays;
import subway.util.ExceptionMessage;

public enum SectionCommand {
    SECTION_REGISTER("1"),
    SECTION_DELETE("2"),
    GO_BACK("B");

    private final String command;

    SectionCommand(String command) {
        this.command = command;
    }

    public static SectionCommand from(String command) {
        return Arrays.stream(SectionCommand.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_COMMAND.getMessage()));
    }
}
