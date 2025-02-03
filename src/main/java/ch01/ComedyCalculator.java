package ch01;

public class ComedyCalculator extends PerformanceCalculator {
    public ComedyCalculator(Performance aPerformance, Play aPlay) {
        super(aPerformance, aPlay);
    }

    @Override
    public int amount() {
        int result = 30000;
        if (performance.audience() > 20) {
            result += 10000 + 500 * (performance.audience() - 20);
        }
        result += 300 * performance.audience();

        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + performance.audience() / 5 ;
    }
}
