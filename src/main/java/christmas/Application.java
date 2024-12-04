package christmas;

import christmas.controller.ChristmasController;
import christmas.domain.FoodRepository;
import christmas.domain.OrderRepository;
import christmas.initializer.MenuInitializer;
import christmas.service.BadgeService;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.service.PaymentService;
import christmas.service.discount.DayDiscount;
import christmas.service.discount.GiveawayEvent;
import christmas.service.discount.SpecialDiscount;
import christmas.service.discount.WeekdaysDiscount;
import christmas.service.discount.WeekendDiscount;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        MenuInitializer initializer = new MenuInitializer(FoodRepository.getInstance());

        OrderService orderService = new OrderService(FoodRepository.getInstance(), OrderRepository.getInstance());

        DayDiscount dayDiscount = new DayDiscount();
        WeekdaysDiscount weekdaysDiscount = new WeekdaysDiscount();
        WeekendDiscount weekendDiscount = new WeekendDiscount();
        SpecialDiscount specialDiscount = new SpecialDiscount();
        GiveawayEvent giveawayEvent = new GiveawayEvent();
        DiscountService discountService = new DiscountService(dayDiscount, weekdaysDiscount, weekendDiscount, specialDiscount, giveawayEvent, OrderRepository.getInstance());

        BadgeService badgeService = new BadgeService();

        PaymentService paymentService = new PaymentService(OrderRepository.getInstance());

        ChristmasController controller = new ChristmasController(outputView, initializer, orderService, discountService, badgeService, paymentService);

        controller.run();
    }
}
