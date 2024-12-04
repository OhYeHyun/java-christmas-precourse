package christmas.service.discount;

import java.util.List;

public class SpecialDiscount {
    private static final List<Integer> SPECIAL = List.of(3, 10, 17, 24, 25, 31);

    private boolean apply(int day) {
        return SPECIAL.contains(day);
    }

    public int calculate(int day) {
        if (apply(day)) {
            return 1000;
        }
        return 0;
    }
}
