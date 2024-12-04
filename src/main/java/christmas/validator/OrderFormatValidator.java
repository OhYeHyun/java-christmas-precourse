package christmas.validator;

public class OrderFormatValidator {

    public static void validate(String input) {
        validateFormat(input);
    }

    private static void validateFormat(String input) {
        String[] orders = input.split(",", -1);

        for (String order : orders) {
            String[] orderAttribute = order.split("-", -1);
            if (orderAttribute.length != 2) {
                throw new IllegalArgumentException("[ERROR] 형식을 올바르게 입력해 주세요.");
            }
            NumberFormatValidator.validate(orderAttribute[1]);
        }
    }
}
