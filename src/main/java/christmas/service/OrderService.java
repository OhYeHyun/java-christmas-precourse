package christmas.service;

import christmas.domain.Food;
import christmas.domain.FoodRepository;
import christmas.domain.OrderRepository;

public class OrderService {
    private final FoodRepository menu;
    private final OrderRepository order;

    public OrderService(FoodRepository menu, OrderRepository order) {
        this.menu = menu;
        this.order = order;
    }

    public void order(String name, int quantity) {
        validateName(name);
        validateQuantity(quantity);

        Food food = menu.findFood(name);
        order.orderFood(food, quantity);
    }

    public void validateOrder() {
        validateTotalPrice();
        validateType();
        validateTotalQuantity();
    }

    private void validateName(String name) {
        if (!menu.isExist(name)) {
            order.clear();
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        if (order.isExist(name)) {
            order.clear();
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 1) {
            order.clear();
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateTotalPrice() {
        if (order.totalPrice() < 10000) {
            System.out.println("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        }
    }

    private void validateType() {
        if (order.countByType("음료") == order.getOrder().size()) {
            order.clear();
            throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        }
    }

    private void validateTotalQuantity() {
        if (order.getOrder().size() > 20) {
            order.clear();
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }
}
