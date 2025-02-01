package ch01;

import java.util.List;
import java.util.Map;

public class StatementDataFactory {

    private Map<String, Play> plays;

    public StatementDataFactory(Map<String, Play> plays) {
        this.plays = plays;
    }

    public StatementData createStatementData(Invoice invoice) {
        List<PerformanceData> performances = invoice.performances().stream()
                .map(this::enrichPerformance)
                .toList();

        return new StatementData(
                invoice.customer(),
                performances,
                totalAmount(performances),
                totalVolumeCredits(performances)
        );
    }

    private PerformanceData enrichPerformance(Performance aPerformance) {
        return new PerformanceData(
                aPerformance.playID(),
                aPerformance.audience(),
                playFor(aPerformance),
                amountFor(aPerformance),
                volumeCreditsFor(aPerformance)
        );
    }

    private int totalAmount(List<PerformanceData> performances) {
        return performances.stream()
                .mapToInt(PerformanceData::amount)
                .sum();
    }

    private int totalVolumeCredits(List<PerformanceData> performances) {
        return performances.stream()
                .mapToInt(PerformanceData::volumeCredits)
                .sum();
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

    private int volumeCreditsFor(Performance perf) {
        int volumeCredits = 0;
        volumeCredits += Math.max(perf.audience() - 30, 0);

        if ("comedy".equals(playFor(perf).type())) {
            volumeCredits += Math.floor(perf.audience() / 5);
        }
        return volumeCredits;
    }

}
