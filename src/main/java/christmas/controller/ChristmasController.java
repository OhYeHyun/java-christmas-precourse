package christmas.controller;

import christmas.domain.Food;
import christmas.initializer.MenuInitializer;
import christmas.service.BadgeService;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.service.PaymentService;
import christmas.validator.DayBusinessValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;

public class ChristmasController {
    private final OutputView outputView;
    private final MenuInitializer initializer;
    private final OrderService orderService;
    private final DiscountService discountService;
    private final BadgeService badgeService;
    private final PaymentService paymentService;

    public ChristmasController(OutputView outputView, MenuInitializer initializer, OrderService orderService, DiscountService discountService, BadgeService badgeService, PaymentService paymentService) {
       this.outputView = outputView;
       this.initializer = initializer;
       this.orderService = orderService;
       this.discountService = discountService;
       this.badgeService = badgeService;
       this.paymentService = paymentService;
    }

    public void run() {
        int day = processGetDay();
        processOrder();
        processCalculate(day);
        processDisplay();
    }

    private int processGetDay() {
        initializer.initialize();
        OutputView.instructionBeginning();
        int day = getDay();
        outputView.instructionService(day);

        return day;
    }

    private void processCalculate(int day) {
        discountService.discount(day);
        paymentService.calculate(discountService.totalPaymentPrice());
        badgeService.give(discountService.totalDiscountPrice());
    }

    private void processDisplay() {
        Map<Food, Integer> orders = orderService.getOrder();
        outputView.displayOrder(orders);

        int beforePrice = paymentService.getBeforePrice();
        outputView.displayBeforePrice(beforePrice);

        List<String> giveaway = discountService.getGiveawayHistory();
        outputView.displayGiveaway(giveaway);

        Map<String, Integer> discount = discountService.getDiscountHistory();
        outputView.displayDiscount(discount);

        int discountPrice = discountService.totalDiscountPrice();
        outputView.displayDiscountPrice(discountPrice);

        int afterPrice = paymentService.getAfterPrice();
        outputView.displayAfterPrice(afterPrice);

        String badge = badgeService.getBadge();
        outputView.displayBadge(badge);
    }

    private int getDay() {
        while (true) {
            try {
                int day = Integer.parseInt(InputView.getDay());
                DayBusinessValidator.validate(day);
                return day;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processOrder() {
        while (true) {
            try {
                String[] orders = InputView.getOrders().split(",", -1);

                for (String order : orders) {
                    String[] attribute = order.split("-", -1);
                    orderService.order(attribute[0], Integer.parseInt(attribute[1]));
                }
                orderService.validateOrder();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
