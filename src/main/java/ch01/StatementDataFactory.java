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
        PerformanceCalculator calculator = createPerformanceCalculator(aPerformance, playFor(aPerformance));

        return new PerformanceData(
                aPerformance.playID(),
                aPerformance.audience(),
                calculator.getPlay(),
                calculator.amount(),
                calculator.volumeCredits()
        );
    }

    private PerformanceCalculator createPerformanceCalculator(Performance aPerformance, Play aPlay) {
        return switch (aPlay.type()) {
            case "tragedy" -> new TragedyCalculator(aPerformance, aPlay);
            case "comedy" -> new ComedyCalculator(aPerformance, aPlay);
            default -> throw new IllegalArgumentException("알 수 없는 장르:" + aPlay.type());
        };
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

}
