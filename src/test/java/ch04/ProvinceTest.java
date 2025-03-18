package ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ProvinceTest {

    private Province province;

    @BeforeEach
    void beforeEach() {
        List<ProducerSaveRequest> producerSaveRequests = List.of(
                new ProducerSaveRequest("Byzantium", 10L, 9L),
                new ProducerSaveRequest("Attalia", 12L, 10L),
                new ProducerSaveRequest("Sinope", 10L, 6L)
        );
        province = new Province("Asia", 30L, 20L, producerSaveRequests);
    }

    @Test
    void shortfall() {
        assertThat(province.shortfall()).isEqualTo(5L);
    }

    @Test
    void profit() {
        assertThat(province.profit()).isEqualTo(230);
    }

    @Test
    void change_production() {
        province.getProducers().get(0).setProduction("20");
        assertThat(province.shortfall()).isEqualTo(-6);
        assertThat(province.profit()).isEqualTo(292);
    }

}