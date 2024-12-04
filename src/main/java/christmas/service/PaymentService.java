package christmas.service;

import christmas.domain.OrderRepository;

public class PaymentService {
    private int beforePrice;
    private int discountPrice;
    private int afterPrice;

    public void calculate(OrderRepository order, int discountPrice) {
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
