package christmas.service;

import christmas.domain.OrderRepository;

public class PaymentService {
    private final OrderRepository order;

    private int beforePrice;
    private int discountPrice;
    private int afterPrice;

    public PaymentService(OrderRepository order) {
        this.order = order;
    }

    public void calculate(int discountPrice) {
        beforePrice = order.totalPrice();
        this.discountPrice = discountPrice;
        afterPrice = beforePrice - discountPrice;
    }

    public int getBeforePrice() {
        return beforePrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getAfterPrice() {
        return afterPrice;
    }
}
