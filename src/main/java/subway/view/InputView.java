package subway.view;

import java.util.Scanner;
import subway.domain.command.LineCommand;
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

    public String readAddStationName() {
        System.out.println(Message.INPUT_ADD_STATION_MESSAGE.message);
        return scanner.next();
    }

    public String readDeleteStationName() {
        System.out.println(Message.INPUT_DELETE_STATION_MESSAGE.message);
        return scanner.next();
    }

    public String readAddLineName() {
        System.out.println(Message.INPUT_ADD_LINE_NAME_MESSAGE.message);
        return scanner.next();
    }

    public LineCommand readLineCommand() {
        System.out.println(Message.INPUT_CHOICE_MENU_MESSAGE.message);
        return LineCommand.from(scanner.next());
    }

    private enum Message {
        INPUT_CHOICE_MENU_MESSAGE("## 원하는 기능을 선택하세요."),
        INPUT_ADD_STATION_MESSAGE("## 등록할 역 이름을 입력하세요."),
        INPUT_DELETE_STATION_MESSAGE("## 삭제할 역 이름을 입력하세요."),
        INPUT_ADD_LINE_NAME_MESSAGE("## 등록할 노선 이름을 입력하세요."),
        INPUT_LINE_FIRST_NAME_MESSAGE("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
        INPUT_LINE_LAST_NAME_MESSAGE("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
        INPUT_DELETE_LINE_MESSAGE("## 삭제할 역 이름을 입력하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
