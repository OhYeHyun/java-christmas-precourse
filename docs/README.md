## 기능 목록
- DayDiscount
- [ ] : 25일 이전인지 확인
- [ ] : 날마다 100원 할인

- WeekdaysDiscount
- [ ] : 일요일 ~ 목요일인지 확인
- [ ] : 디저트 메뉴이면 개당 2023원 할인

- WeekendDiscount
- [ ] : 금요일, 토요일인지 확인
- [ ] : 메인 메뉴이면 개당 2023원 할인

- SpecialDiscount
- [ ] : 별 붙은 날인지 확인
- [ ] : 1000원 할인

- GiveawayEvent
- [ ] : 12만원 이상인지 확인
- [ ] : 샴페인 1개 증정 가격 할인

- BadgeService
- [ ] : 배지 부여

- DiscountService
- [ ] : 방문할 날짜 1 ~ 31 인지 확인

- [ ] : 모든 할인 계산하여 Map<할인 이름, 할인 가격>에 추가
- [ ] : 총 혜택 금액 계산

- OrderService
- [ ] : 메뉴가 FoodRepository 에 존재하는지 확인
- [ ] : 메뉴가 OrderRepository 에 존재하지 않는지 확인
- [ ] : 개수가 1 이상인지 확인
- [ ] : 총 주문 금액이 10000원 이상인지 확인
- [ ] : 음료만은 주문 불가
- [ ] : 최대 20개까지 주문 가능

- [ ] : OrderRepository 에 추가

- PaymentService
- [ ] : 할인 후 예상 결제 금액 계산

- Food
- [ ] : 이름, 가격, 코스 타입을 갖는 객체

- FoodRepository
- [ ] : List<Food>

- OrderRepository
- [ ] : Map<Food, Integer>

- NumberFormatValidator
- [ ] : 숫자인지 확인

- OrderFormatValidator
- [ ] : 음식-개수,음식-개수 형식인지 확인
- [ ] : 수량이 숫자인지 확인