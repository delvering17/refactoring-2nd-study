package ch04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ProvinceTest {

    @Test
    void shortfall() {
        List<ProducerSaveRequest> producerSaveRequests = List.of(
                new ProducerSaveRequest("Byzantium", 10L, 9L),
                new ProducerSaveRequest("Attalia", 12L, 10L),
                new ProducerSaveRequest("Sinope", 10L, 6L)
        );
        Province province = new Province("Asia", 30L, 20L, producerSaveRequests);
        assertThat(province.shortfall()).isEqualTo(5L);
    }

    @Test
    void profit() {
        List<ProducerSaveRequest> producerSaveRequests = List.of(
                new ProducerSaveRequest("Byzantium", 10L, 9L),
                new ProducerSaveRequest("Attalia", 12L, 10L),
                new ProducerSaveRequest("Sinope", 10L, 6L)
        );
        Province province = new Province("Asia", 30L, 20L, producerSaveRequests);
        assertThat(province.profit()).isEqualTo(230);
    }

}