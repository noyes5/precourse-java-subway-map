package subway.util;

public enum ExceptionMessage {
    NO_SUCH_MAIN_COMMAND("메뉴가 존재하지 않습니다. 메뉴 번호를 입력해주세요."),
    DUPLICATED_STATION_IN_LINE("해당 노선에 이미 등록된 역입니다."),
    INVALID_STATION_NAME("존재하지 않는 역 이름입니다.");


    private String message;
    private static final String BASE_MESSAGE = "[ERROR] %s";

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
