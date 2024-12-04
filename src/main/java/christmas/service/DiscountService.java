package christmas.service;

import christmas.domain.OrderRepository;
import christmas.service.discount.DayDiscount;
import christmas.service.discount.GiveawayEvent;
import christmas.service.discount.SpecialDiscount;
import christmas.service.discount.WeekdaysDiscount;
import christmas.service.discount.WeekendDiscount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DiscountService {
    private final DayDiscount dayDiscount;
    private final WeekdaysDiscount weekdaysDiscount;
    private final WeekendDiscount weekendDiscount;
    private final SpecialDiscount specialDiscount;
    private final GiveawayEvent giveawayEvent;

    private final OrderRepository order;

    private final Map<String, Integer> discountHistory = new HashMap<>();
    private final List<String> giveawayHistory = new ArrayList<>();

    public DiscountService(DayDiscount dayDiscount, WeekdaysDiscount weekdaysDiscount, WeekendDiscount weekendDiscount, SpecialDiscount specialDiscount, GiveawayEvent giveawayEvent, OrderRepository order) {
        this.dayDiscount = dayDiscount;
        this.weekdaysDiscount = weekdaysDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
        this.giveawayEvent = giveawayEvent;
        this.order = order;
    }

    public void discount(int day) {
        discountHistory.put("크리스마스 디데이 할인", dayDiscount.calculate(day));
        discountHistory.put("평일 할인", weekdaysDiscount.calculate(day, order));
        discountHistory.put("주말 할인", weekendDiscount.calculate(day, order));
        discountHistory.put("특별 할인", specialDiscount.calculate(day));
        discountHistory.put("증정 이벤트", giveawayEvent.calculate(order));

        if (discountHistory.get("증정 이벤트") > 0) {
            giveawayHistory.add("샴페인 1개");
        }
        if (discountHistory.get("증정 이벤트") == 0) {
            giveawayHistory.add("없음");
        }
    }

    public int totalDiscountPrice() {
        return discountHistory.values().stream()
                .mapToInt(price -> price)
                .sum();
    }

    public int totalPaymentPrice() {
        return discountHistory.entrySet().stream()
                .filter(entry -> !Objects.equals(entry.getKey(), "증정 이벤트"))
                .mapToInt(entry -> entry.getValue())
                .sum();
    }

    public Map<String, Integer> getDiscountHistory() {
        return Collections.unmodifiableMap(discountHistory);
    }

    public List<String> getGiveawayHistory() {
        return Collections.unmodifiableList(giveawayHistory);
    }
}
