package christmas.service.discount;

import christmas.domain.OrderRepository;

public class GiveawayEvent {

    private boolean apply(OrderRepository order) {
        return order.totalPrice() >= 120000;
    }

    public int calculate(OrderRepository order) {
        if (apply(order)) {
            return 25000;
        }
        return 0;
    }
}
