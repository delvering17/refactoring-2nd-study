package ch06.inlineFunction;

import java.util.HashMap;
import java.util.Map;

public class InlineFunction {

    public Map<String, String> reportLines(Customer aCustomer) {
        Map<String, String> lines = new HashMap<>();
        gatherCustomerData(lines, aCustomer);

        return lines;
    }

    private void gatherCustomerData(Map<String, String> out, Customer aCustomer) {
        out.put("name", aCustomer.name());
        out.put("location", aCustomer.location());
    }

}
