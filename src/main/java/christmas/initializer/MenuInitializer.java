package christmas.initializer;

import christmas.domain.Food;
import christmas.domain.FoodRepository;

public class MenuInitializer {
    private final FoodRepository menu;

    public MenuInitializer(FoodRepository menu) {
        this.menu = menu;
    }

    public void initialize() {
        menu.addFood(new Food("양송이수프", 6000, "에피타이저"));
        menu.addFood(new Food("타파스", 5500, "에피타이저"));
        menu.addFood(new Food("시저샐러드", 8000, "에피타이저"));
        menu.addFood(new Food("티본스테이크", 55000, "메인"));
        menu.addFood(new Food("바비큐립", 54000, "메인"));
        menu.addFood(new Food("해산물파스타", 35000, "메인"));
        menu.addFood(new Food("크리스마스파스타", 25000, "메인"));
        menu.addFood(new Food("초코케이크", 15000, "디저트"));
        menu.addFood(new Food("아이스크림", 5000, "디저트"));
        menu.addFood(new Food("제로콜라", 3000, "음료"));
        menu.addFood(new Food("레드와인", 60000, "음료"));
        menu.addFood(new Food("샴페인", 25000, "음료"));
    }
}
