package ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ProvinceTest {

    private Province province;
    private Province noProducers;

    @BeforeEach
    void beforeEach() {
        List<ProducerSaveRequest> producerSaveRequests = List.of(
                new ProducerSaveRequest("Byzantium", 10L, 9L),
                new ProducerSaveRequest("Attalia", 12L, 10L),
                new ProducerSaveRequest("Sinope", 10L, 6L)
        );
        province = new Province("Asia", 30L, 20L, producerSaveRequests);
        noProducers = new Province("No producers", 30L, 20L, List.of());
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

    @Test
    void no_producers_shortfall() {
        assertThat(noProducers.shortfall()).isEqualTo(30);
    }

    @Test
    void no_producers_profit() {
        assertThat(noProducers.profit()).isEqualTo(0);
    }

    @Test
    void zero_demand() {
        province.setDemand("0");
        assertThat(province.shortfall()).isEqualTo(-25);
        assertThat(province.profit()).isEqualTo(0);
    }

    @Test
    void negative_demand() {
        province.setDemand("-1");
        assertThat(province.shortfall()).isEqualTo(-26);
        assertThat(province.profit()).isEqualTo(-10);
    }

    @Test
    void empty_string_demand() {
        assertThatThrownBy(() -> province.setDemand("")).isInstanceOf(NumberFormatException.class);
    }

}