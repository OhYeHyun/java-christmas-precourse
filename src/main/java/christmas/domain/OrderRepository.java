package christmas.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderRepository {
    private final OrderRepository instance = new OrderRepository();
    private final Map<Food, Integer> order = new HashMap<>();

    private OrderRepository() {}

    public OrderRepository getInstance() {
        return instance;
    }

    public void orderFood(Food food, int quantity) {
        order.put(food, quantity);
    }

    public boolean isExist(String name) {
        return !order.keySet().stream()
                .filter(food -> Objects.equals(food.getName(), name))
                .toList()
                .isEmpty();
    }

    public int countByType(String type) {
        return order.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getKey().getType(), type))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int totalPrice() {
        return order.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void clear() {
        order.clear();
    }

    public Map<Food, Integer> getOrder() {
        return Collections.unmodifiableMap(order);
    }
}
