package christmas.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OrderRepository {
    private final OrderRepository instance = new OrderRepository();
    private final List<Food> order = new ArrayList<>();

    private OrderRepository() {}

    public OrderRepository getInstance() {
        return instance;
    }

    public void orderFood(Food food) {
        order.add(food);
    }

    public boolean isExist(String name) {
        return !order.stream()
                .filter(food -> Objects.equals(food.getName(), name))
                .toList()
                .isEmpty();
    }

    public int countByType(String type) {
        return order.stream()
                .filter(food -> Objects.equals(food.getType(), type))
                .toList()
                .size();
    }


    public List<Food> getOrder() {
        return Collections.unmodifiableList(order);
    }
}
