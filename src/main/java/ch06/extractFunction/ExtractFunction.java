package ch06.extractFunction;

import java.time.LocalDate;

public class ExtractFunction {

    public void printOwing(Invoice invoice) {
        int outstanding = 0;

        System.out.println("***********");
        System.out.println("****고객채무***");
        System.out.println("***********");

        for (Order order : invoice.orders) {
            outstanding += order.amount();
        }

        LocalDate today = LocalDate.now();
        invoice.dueDate = today.plusDays(30);

        System.out.println("고객명: " + invoice.customer);
        System.out.println("채무액: " + outstanding);
        System.out.println("마감일: " + invoice.dueDate);
    }


}
