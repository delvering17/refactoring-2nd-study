package ch01;

import java.util.List;

public record StatementData(
        String customer,
        List<PerformanceData> performances,
        int totalAmount,
        int totalVolumeCredits
) {

}
