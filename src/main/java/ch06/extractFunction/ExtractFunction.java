package ch06.extractFunction;

import java.time.LocalDate;

public class ExtractFunction {

    public void printOwing(Invoice invoice) {


        printBanner();

        int outstanding = 0;
        for (Order order : invoice.orders) {
            outstanding += order.amount();
        }

        recordDueDate(invoice);

        printDetails(invoice, outstanding);
    }

    private void printBanner() {
        System.out.println("***********");
        System.out.println("****고객채무***");
        System.out.println("***********");
    }

    private int calculateOutstanding(Invoice invoice) {
        int outstanding = 0;
        for (Order order : invoice.orders) {
            outstanding += order.amount();
        }

        return outstanding;
    }

    private void recordDueDate(Invoice invoice) {
        LocalDate today = LocalDate.now();
        invoice.dueDate = today.plusDays(30);
    }

    private void printDetails(Invoice invoice, int outstanding) {
        System.out.println("고객명: " + invoice.customer);
        System.out.println("채무액: " + outstanding);
        System.out.println("마감일: " + invoice.dueDate);
    }

}
