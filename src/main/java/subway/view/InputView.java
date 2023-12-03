package subway.view;

import java.util.Scanner;

public class InputView {

    public int readMenuNumber(Scanner scanner) {
        System.out.println(Message.INPUT_MENU_MESSAGE.message);
        return scanner.nextInt();
    }


    private enum Message {
        INPUT_MENU_MESSAGE("## 원하는 기능을 선택하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
