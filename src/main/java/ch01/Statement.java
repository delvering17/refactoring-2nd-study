package ch01;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Statement {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "청구 내역(고객명: " + invoice.customer() + ")\n";
        DecimalFormat format = new DecimalFormat("$#.00");

        for (Performance perf : invoice.performances()) {
            Play play = plays.get(perf.playID());
            int thisAmount = 0;

            thisAmount = amountFor(perf, play);

            // 포인트를 적립한다.
            volumeCredits += Math.max(perf.audience() - 30, 0);
            // 희극 관객 5명마다 추가 포인트를 제공한다.
            if ("comedy".equals(play.type())) {
                volumeCredits += Math.floor(perf.audience() / 5);
            }

            // 청구 내역을 출력한다.
            result += "  " + play.name() + ": " + format.format(thisAmount / 100) + " (" + perf.audience() + "석)\n";
            totalAmount += thisAmount;
        }
        result += "총액: " + format.format(totalAmount/100) + "\n";
        result += "적립 포인트: " + volumeCredits + "점\n";
        return result;
    }

    private int amountFor(Performance perf, Play play) {
        int thisAmount = 0;

        switch (play.type()) {
            case "tragedy": // 비극
                thisAmount = 40000;
                if (perf.audience() > 30) {
                    thisAmount += 1000 * (perf.audience() - 30);
                }
                break;
            case "comedy": // 희극
                thisAmount = 30000;
                if (perf.audience() > 20) {
                    thisAmount += 10000 + 500 * (perf.audience() - 20);
                }
                thisAmount += 300 * perf.audience();
                break;
            default:
                throw new RuntimeException("알 수 없는 장르: " + play.type());
        }

        return thisAmount;
    }

    public static void main(String[] args) {
        Statement statement = new Statement();
        String customer = "BigCo";
        List<Performance> performances = List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        );

        Invoice invoice = new Invoice(customer, performances);

        Map<String, Play> plays = Map.of(
                "hamlet", new Play("hamlet", "tragedy"),
                "as-like", new Play("As You Like It", "comedy"),
                "othello", new Play("Othello", "tragedy")
        );

        String result = statement.statement(invoice, plays);

        System.out.println(result);
    }

}
