package christmas.service.discount;

import christmas.domain.OrderRepository;
import java.util.List;

public class WeekendDiscount {
    private static final List<Integer> WEEKDAYS = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);

    private boolean apply(int day) {
        return WEEKDAYS.contains(day);
    }

    public int calculate(int day, OrderRepository order) {
        if (apply(day)) {
            int count = order.countByType("메인");
            return count * 2023;
        }
        return 0;
    }
}
