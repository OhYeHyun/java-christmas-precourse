package christmas.service.discount;

public class DayDiscount {

    private boolean apply(int day) {
        return day <= 25;
    }

    public int calculate(int day) {
        if (apply(day)) {
            return 1000 + (day - 1) * 100;
        }
        return 0;
    }
}
