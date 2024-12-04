package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.NumberFormatValidator;
import christmas.validator.OrderFormatValidator;

public class InputView {

    private static String getInput() {
        return Console.readLine();
    }

    public static String getDay() {
        while (true) {
            try {
                String day = getInput();
                NumberFormatValidator.validate(day);
                return day;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getOrders() {
        while (true) {
            try {
                String orders = getInput();
                OrderFormatValidator.validate(orders);
                return orders;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
