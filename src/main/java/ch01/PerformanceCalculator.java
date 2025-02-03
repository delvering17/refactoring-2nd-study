package ch01;

public class PerformanceCalculator {

    protected final Performance performance;
    protected final Play play;

    public PerformanceCalculator(Performance aPerformance, Play aPlay) {
        this.performance = aPerformance;
        this.play = aPlay;
    }

    public Play getPlay() {
        return play;
    }

    public int amount() {
        int result = 0;

        switch (play.type()) {
            case "tragedy": // 비극
                throw new RuntimeException("오류 발생");
            case "comedy": // 희극
                result = 30000;
                if (performance.audience() > 20) {
                    result += 10000 + 500 * (performance.audience() - 20);
                }
                result += 300 * performance.audience();
                break;
            default:
                throw new RuntimeException("알 수 없는 장르: " + play.type());
        }

        return result;
    }

    public int volumeCredits() {
        int volumeCredits = 0;
        volumeCredits += Math.max(performance.audience() - 30, 0);

        if ("comedy".equals(play.type())) {
            volumeCredits += Math.floor(performance.audience() / 5);
        }
        return volumeCredits;
    }

}
