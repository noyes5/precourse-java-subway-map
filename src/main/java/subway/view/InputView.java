package subway.view;

import java.util.Scanner;
import subway.domain.command.LineCommand;
import subway.domain.command.MainCommand;
import subway.domain.command.SectionCommand;
import subway.domain.command.StationCommand;
import subway.util.InputValidator;

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

    public SectionCommand readSectionCommand() {
        System.out.println(Message.INPUT_CHOICE_MENU_MESSAGE.message);
        return SectionCommand.from(scanner.next());
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

    public String readFirstStation() {
        System.out.println(Message.INPUT_LINE_FIRST_NAME_MESSAGE.message);
        return scanner.next();
    }

    public String readLastStation() {
        System.out.println(Message.INPUT_LINE_LAST_NAME_MESSAGE.message);
        return scanner.next();
    }

    public String readDeleteLineName() {
        System.out.println(Message.INPUT_DELETE_LINE_MESSAGE.message);
        return scanner.next();
    }

    public String readLineNameForAddSection() {
        System.out.println(Message.INPUT_LINE_FOR_SECTION_MESSAGE.message);
        return scanner.next();
    }

    public String readStationNameForAddSection() {
        System.out.println(Message.INPUT_STATION_FOR_SECTION_MESSAGE.message);
        return scanner.next();
    }

    public int readSectionIndex() {
        System.out.println(Message.INPUT_SECTION_ORDER_MESSAGE.message);
        String input = scanner.next();
        InputValidator.validateIndexNumber(input);
        return Integer.parseInt(input);
    }

    public String readLineNameForDeleteSection() {
        System.out.println(Message.INPUT_LINE_FOR_SECTION_DELETE_MESSAGE.message);
        return scanner.next();
    }

    private enum Message {
        INPUT_CHOICE_MENU_MESSAGE("## 원하는 기능을 선택하세요."),
        INPUT_ADD_STATION_MESSAGE("## 등록할 역 이름을 입력하세요."),
        INPUT_DELETE_STATION_MESSAGE("## 삭제할 역 이름을 입력하세요."),
        INPUT_ADD_LINE_NAME_MESSAGE("## 등록할 노선 이름을 입력하세요."),
        INPUT_LINE_FIRST_NAME_MESSAGE("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
        INPUT_LINE_LAST_NAME_MESSAGE("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
        INPUT_DELETE_LINE_MESSAGE("## 삭제할 역 이름을 입력하세요."),
        INPUT_LINE_FOR_SECTION_MESSAGE("## 노선을 입력하세요."),
        INPUT_STATION_FOR_SECTION_MESSAGE("## 역이름을 입력하세요."),
        INPUT_SECTION_ORDER_MESSAGE("## 순서를 입력하세요."),
        INPUT_LINE_FOR_SECTION_DELETE_MESSAGE("## 삭제할 구간의 노선을 입력하세요."),
        INPUT_STATION_FOR_SECTION_DELETE_MESSAGE("## 삭제할 구간의 역을 입력하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
