package christmas.service.discount;

import christmas.domain.OrderRepository;
import java.util.List;

public class WeekdaysDiscount {
    private static final List<Integer> WEEKDAYS = List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31);

    private boolean apply(int day) {
        return WEEKDAYS.contains(day);
    }

    public int calculate(int day, OrderRepository order) {
        if (apply(day)) {
            int count = order.countByType("디저트");
            return count * 2023;
        }
        return 0;
    }
}
