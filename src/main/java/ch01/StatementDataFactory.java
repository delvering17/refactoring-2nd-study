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
        PerformanceCalculator calculator = new PerformanceCalculator(aPerformance, playFor(aPerformance));

        return new PerformanceData(
                aPerformance.playID(),
                aPerformance.audience(),
                calculator.getPlay(),
                calculator.amount(),
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

    private int volumeCreditsFor(Performance perf) {
        int volumeCredits = 0;
        volumeCredits += Math.max(perf.audience() - 30, 0);

        if ("comedy".equals(playFor(perf).type())) {
            volumeCredits += Math.floor(perf.audience() / 5);
        }
        return volumeCredits;
    }

}
