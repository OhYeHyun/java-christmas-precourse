package christmas.validator;

public class NumberFormatValidator {

    public static void validate(String input) {
        validateIsNumeric(input);
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해 주세요.");
        }
    }
}
