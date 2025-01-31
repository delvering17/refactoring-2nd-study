package ch01;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Statement {

    private Map<String, Play> plays;

    public String statement(Invoice invoice, Map<String, Play> plays) {
        // 생성자로 plays를 넣거나 현재처럼 넣거나이지만 예제의 함수를 최대한 변경하지 않으려 이곳에서 값 할당.
        this.plays = plays;
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "청구 내역(고객명: " + invoice.customer() + ")\n";
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.performances()) {
            volumeCredits = volumeCreditsFor(perf);

            // 청구 내역을 출력한다.
            result += "    " + playFor(perf).name() + ": " + format.format((double) amountFor(perf) / 100) + " (" + perf.audience() + "석)\n";
            totalAmount += amountFor(perf);
        }
        result += "총액: " + format.format((double) totalAmount / 100) + "\n";
        result += "적립 포인트: " + volumeCredits + "점\n";
        return result;
    }

    private int volumeCreditsFor(Performance perf) {
        int volumeCredits = 0;
        volumeCredits += Math.max(perf.audience() - 30, 0);

        if ("comedy".equals(playFor(perf).type())) {
            volumeCredits += Math.floor(perf.audience() / 5);
        }
        return volumeCredits;
    }

    private Play playFor(Performance perf) {
        return this.plays.get(perf.playID());
    }

    private int amountFor(Performance aPerformance) {
        int result = 0;

        switch (playFor(aPerformance).type()) {
            case "tragedy": // 비극
                result = 40000;
                if (aPerformance.audience() > 30) {
                    result += 1000 * (aPerformance.audience() - 30);
                }
                break;
            case "comedy": // 희극
                result = 30000;
                if (aPerformance.audience() > 20) {
                    result += 10000 + 500 * (aPerformance.audience() - 20);
                }
                result += 300 * aPerformance.audience();
                break;
            default:
                throw new RuntimeException("알 수 없는 장르: " + playFor(aPerformance).type());
        }

        return result;
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
