package ch04;

import java.math.BigInteger;

public record ProducerSaveRequest(
        String name,
        Long cost,
        Long production
) {

}
