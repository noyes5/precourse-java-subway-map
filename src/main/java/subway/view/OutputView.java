package subway.view;

import static subway.util.CompleteMessage.COMPLETE_LINE_DELETE;
import static subway.util.CompleteMessage.COMPLETE_LINE_REGISTRATION;
import static subway.util.CompleteMessage.COMPLETE_STATION_DELETE;
import static subway.util.CompleteMessage.COMPLETE_STATION_REGISTRATION;

import subway.domain.Line;
import subway.domain.Station;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printMainMenu() {
        System.out.println(Message.SUBWAY_MENU.message);
    }

    public void printStationMenu() {
        System.out.println(Message.STATION_MENU.message);
    }

    public void printCompleteStation() {
        System.out.println(COMPLETE_STATION_REGISTRATION.getMessage());
    }

    public void printDeleteStation() {
        System.out.println(COMPLETE_STATION_DELETE.getMessage());
    }

    public void printStations(Station station) {
        System.out.println("[INFO] " + station.getName());
    }

    public void printLineMenu() {
        System.out.println(Message.LINE_MENU.message);
    }

    public void printCompleteLine() {
        System.out.println(COMPLETE_LINE_REGISTRATION.getMessage());
    }

    public void printLines(Line line) {
        System.out.println("[INFO] " + line.getName());
    }

    public void printDeleteLine() {
        System.out.println(COMPLETE_LINE_DELETE.getMessage());
    }

    private enum Message {
        SUBWAY_MENU("## 메인 화면" + NEW_LINE
                + "1. 역 관리" + NEW_LINE
                + "2. 노선 관리" + NEW_LINE
                + "3. 구간 관리" + NEW_LINE
                + "4. 지하철 노선도 출력" + NEW_LINE
                + "Q. 종료" + NEW_LINE),
        STATION_MENU("## 역 관리 화면" + NEW_LINE +
                "1. 역 등록" + NEW_LINE +
                "2. 역 삭제" + NEW_LINE +
                "3. 역 조회" + NEW_LINE +
                "B. 돌아가기"),
        LINE_MENU("## 노선 관리 화면" + NEW_LINE +
                "1. 노선 등록" + NEW_LINE +
                "2. 노선 삭제" + NEW_LINE +
                "3. 노선 조회" + NEW_LINE +
                "B. 돌아가기"),
        SECTION_MENU("## 구간 관리 화면" + NEW_LINE +
                "1. 구간 등록" + NEW_LINE +
                "2. 구간 삭제" + NEW_LINE +
                "B. 돌아가기");

        private final String message;

        Message(String message) {
            this.message = message;
        }
        }
}
