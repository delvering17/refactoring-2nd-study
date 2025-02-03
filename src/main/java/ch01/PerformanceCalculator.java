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
        throw new UnsupportedOperationException("서브클래스에서 처리하도록 설계되었습니다.");
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
