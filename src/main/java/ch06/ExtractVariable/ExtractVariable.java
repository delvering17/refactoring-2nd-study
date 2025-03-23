package ch06.ExtractVariable;

public class ExtractVariable {

    public double price(Order order) {
        // 가격(price) = 기본 가격 - 수량 할인 + 배송비
        return order.quantity() * order.itemPrice() -
                Math.max(0, order.quantity()) * order.itemPrice() * 0.05 +
                Math.min(order.quantity() * order.itemPrice() * 0.1, 100);
    }

}
