package subway.util;

public enum ExceptionMessage {
    CANNOT_REMOVE_STATION("역의 갯수가 작아 삭제할 수 없습니다."),
    NO_SUCH_COMMAND("선택할 수 없는 기능입니다."),
    DUPLICATED_STATION_MESSAGE("이미 등록된 역입니다."),
    DUPLICATION_LINE_MESSAGE("이미 등록된 노선입니다."),
    ALREADY_REGISTERED_IN_LINE("이미 노선에 역이 등록되어 있습니다."),
    INVALID_SECTION_INDEX("구간 값을 제대로 입력해주세요."),
    INVALID_LINE_NAME("존재하지 않는 노선 이름입니다."),
    INVALID_NUMERIC_INPUT("입력값은 숫자만 입력가능합니다."),
    INVALID_STATION_NAME("존재하지 않는 역 이름입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 두 글자 이상 입력해야 합니다."),
    MIN_LINE_NAME_LENGTH("노선 이름은 2글자 이상이어야 합니다."),
    STATION_DELETE_NOT_ALLOWED("노선에 등록된 역은 삭제할 수 없습니다.");

    private String message;
    private static final String BASE_MESSAGE = "[ERROR] %s";

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
