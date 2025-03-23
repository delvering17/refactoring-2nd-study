package ch06.InlineVariable;

public class InlineVariable {

    public boolean inlineVariable(Order order) {
        var basePrice = order.basePrice;

        return basePrice > 1000;
    }

    record Order(int basePrice) {}

}
