package christmas.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FoodRepository {
    private final FoodRepository instance = new FoodRepository();
    private final List<Food> foods = new ArrayList<>();

    private FoodRepository() {}

    public FoodRepository getInstance() {
        return instance;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public boolean isExist(String name) {
        return !foods.stream()
                .filter(food -> Objects.equals(food.getName(), name))
                .toList()
                .isEmpty();
    }

    public List<Food> getFoods() {
        return Collections.unmodifiableList(foods);
    }
}
