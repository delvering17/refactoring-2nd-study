package ch06.ExtractVariable;

public class ExtractVariable {

    public double price(Order order) {
        // 가격(price) = 기본 가격 - 수량 할인 + 배송비
        int basePrice = basePrice(order);
        double quantityDiscount = quantityDiscount(order);
        double shipping = getShipping(basePrice);
        return basePrice - quantityDiscount + shipping;
    }

    public int basePrice(Order order) {
        return order.quantity() * order.itemPrice();
    }

    public double quantityDiscount(Order order) {
        return Math.max(0, order.quantity()) * order.itemPrice() * 0.05;
    }


    public double getShipping(int basePrice) {
        return Math.min(basePrice * 0.1, 100);
    }
}
