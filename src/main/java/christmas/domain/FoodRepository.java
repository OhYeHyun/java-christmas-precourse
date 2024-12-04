package christmas.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FoodRepository {
    private static final FoodRepository instance = new FoodRepository();
    private static final List<Food> menu = new ArrayList<>();

    private FoodRepository() {}

    public static FoodRepository getInstance() {
        return instance;
    }

    public void addFood(Food food) {
        menu.add(food);
    }

    public boolean isExist(String name) {
        return !menu.stream()
                .filter(food -> Objects.equals(food.getName(), name))
                .toList()
                .isEmpty();
    }

    public Food findFood(String name) {
        return menu.stream().filter(food -> Objects.equals(food.getName(), name)).findAny().get();
    }

    public List<Food> getMenu() {
        return Collections.unmodifiableList(menu);
    }
}
