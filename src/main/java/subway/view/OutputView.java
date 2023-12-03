package subway.view;

public class OutputView {

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printStart() {
        System.out.println(Message.SUBWAY_MENU.message);
    }

    private enum Message {
        SUBWAY_MENU("## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
