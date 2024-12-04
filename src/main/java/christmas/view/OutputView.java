package christmas.view;

import christmas.domain.Food;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    public static void print(String text) {
        System.out.println(text);
    }

    public static void lineSpace() {
        System.out.print(System.lineSeparator());
    }

    public static void instructionBeginning() {
        print("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void instructionGetDay() {
        print("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void instructionGetOrders() {
        print("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void instructionService(int day) {
        String format = String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", day);
        print(format);
    }

    public void displayOrder(Map<Food, Integer> order) {
        lineSpace();
        print("<주문 메뉴>");

        for (Entry<Food, Integer> food : order.entrySet()) {
            String format = String.format("%s %d개", food.getKey().getName(), food.getValue());
            print(format);
        }
    }

    public void displayBeforePrice(int beforePrice) {
        lineSpace();
        print("<할인 전 총주문 금액>");

        String format = String.format("%,d원", beforePrice);
        print(format);
    }

    public void displayGiveaway(List<String> giveawayHistory) {
        lineSpace();
        print("<증정 메뉴>");

        for (String history : giveawayHistory) {
            print(history);
        }
    }

    public void displayDiscount(Map<String, Integer> discountHistory) {
        lineSpace();
        print("<헤택 내역>");

        int count = 0;
        for (Entry<String, Integer> history : discountHistory.entrySet()) {
            if (history.getValue() != 0) {
                count++;
                String format = String.format("%s: -%,d원", history.getKey(), history.getValue());
                print(format);
            }
        }
        if (count == 0) {
            print("없음");
        }
    }

    public void displayDiscountPrice(int discountPrice) {
        lineSpace();
        print("<총혜택 금액>");

        String format = String.format("-%,d원", discountPrice);
        print(format);
    }

    public void displayAfterPrice(int afterPrice) {
        lineSpace();
        print("<할인 후 예상 결제 금액>");

        String format = String.format("%,d원", afterPrice);
        print(format);
    }

    public void displayBadge(String badge) {
        lineSpace();
        print("<12월 이벤트 배지>");

        print(badge);
    }
}
