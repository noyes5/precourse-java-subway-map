package subway.util;

public enum CompleteMessage {
    COMPLETE_STATION_REGISTRATION("지하철 역이 등록되었습니다."),
    COMPLETE_STATION_DELETE("지하철 역이 삭제되었습니다."),
    COMPLETE_LINE_REGISTRATION("지하철 노선이 등록되었습니다."),
    COMPLETE_LINE_DELETE("지하철 노선이 삭제되었습니다."),
    COMPLETE_SECTION_REGISTRATION("구간이 등록되었습니다"),
    COMPLETE_SECTION_DELETE("구간이 삭제되었습니다."),
    DEFAULT_PRINT_MESSAGE("");

    private String message;
    private static final String BASE_MESSAGE = "[INFO] %s";

    CompleteMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
