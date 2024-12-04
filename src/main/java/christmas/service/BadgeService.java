package christmas.service;

public class BadgeService {
    private String badge;

    public void give(int amount) {
        badge = giveBadge(amount);
    }

    private String giveBadge(int amount) {
        if (amount >= 20000) {
            return "산타";
        }
        if (amount >= 10000) {
            return "트리";
        }
        if (amount >= 5000) {
            return "별";
        }
        return "없음";
    }

    public String getBadge() {
        return badge;
    }
}
