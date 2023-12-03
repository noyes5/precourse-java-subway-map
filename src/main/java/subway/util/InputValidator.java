package subway.util;

import static subway.util.ExceptionMessage.INVALID_NUMERIC_INPUT;

public class InputValidator {
    public static void validateIndexNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
    }
    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
