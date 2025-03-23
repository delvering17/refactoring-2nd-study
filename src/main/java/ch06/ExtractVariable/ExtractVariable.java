package ch06.ExtractVariable;

public class ExtractVariable {

    public double price(Order order) {
        // 가격(price) = 기본 가격 - 수량 할인 + 배송비
        int basePrice = order.quantity() * order.itemPrice();
        double quantityDiscount = Math.max(0, order.quantity()) * order.itemPrice() * 0.05;
        double shipping = Math.min(basePrice * 0.1, 100);
        return basePrice - quantityDiscount + shipping;
    }

}
