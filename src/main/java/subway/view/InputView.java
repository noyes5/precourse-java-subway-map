package subway.view;

import java.util.Scanner;
import subway.domain.command.MainCommand;
import subway.domain.command.StationCommand;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public MainCommand readMainCommand() {
        System.out.println(Message.INPUT_CHOICE_MENU_MESSAGE.message);
        return MainCommand.from(scanner.next());
    }

    public StationCommand readStationCommand() {
        System.out.println(Message.INPUT_CHOICE_MENU_MESSAGE.message);
        return StationCommand.from(scanner.next());
    }

    private enum Message {
        INPUT_CHOICE_MENU_MESSAGE("## 원하는 기능을 선택하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
