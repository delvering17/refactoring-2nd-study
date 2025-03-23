package ch06.inlineFunction;

import java.util.HashMap;
import java.util.Map;

public class InlineFunction {

    public Map<String, String> reportLines(Customer aCustomer) {
        Map<String, String> lines = new HashMap<>();

        lines.put("name", aCustomer.name());
        lines.put("location", aCustomer.location());

        return lines;
    }

}
