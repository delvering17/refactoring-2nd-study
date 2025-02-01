package ch01;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class StatementTest {

    @Test
    public void statement() {
        Statement statement = new Statement();
        String customer = "BigCo";
        List<Performance> performances = List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        );

        Invoice invoice = new Invoice(customer, performances);

        Map<String, Play> plays = Map.of(
                "hamlet", new Play("hamlet", "tragedy"),
                "as-like", new Play("As You Like It", "comedy"),
                "othello", new Play("Othello", "tragedy")
        );

        String result = statement.statement(invoice, plays);

        assertThat(result).isEqualTo(
            """
            청구 내역(고객명: BigCo)
                hamlet: $650.00 (55석)
                As You Like It: $580.00 (35석)
                Othello: $500.00 (40석)
            총액: $1,730.00
            적립 포인트: 47점
            """.stripIndent()
        );
    }


}