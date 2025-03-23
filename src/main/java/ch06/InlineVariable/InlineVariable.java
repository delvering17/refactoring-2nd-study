package ch06.InlineVariable;

public class InlineVariable {

    public boolean inlineVariable(Order order) {

        return order.basePrice > 1000;
    }

    record Order(int basePrice) {}

}
