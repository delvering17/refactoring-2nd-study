package ch01;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Statement {

    public String statement(Invoice invoice, Map<String, Play> plays) {
        StatementData statementData = new StatementDataFactory(plays).createStatementData(invoice);
        return renderPlainText(statementData);
    }

    public String htmlStatement(Invoice invoice, Map<String, Play> plays) {
        StatementData statementData = new StatementDataFactory(plays).createStatementData(invoice);
        return renderHtml(statementData);
    }

    private String renderPlainText(StatementData data) {
        String result = "청구 내역(고객명: " + data.customer() + ")\n";

        for (PerformanceData perf : data.performances()) {
            // 청구 내역을 출력한다.
            result += "    " + perf.play().name() + ": " + usd(perf.amount()) + " (" + perf.audience() + "석)\n";
        }

        result += "총액: " + usd(data.totalAmount()) + "\n";
        result += "적립 포인트: " + data.totalVolumeCredits() + "점\n";
        return result;
    }

    private String renderHtml(StatementData data) {
        String result = "<h1>청구 내역(고객명: " + data.customer() + ")</h1>\n";
        result += "<table>\n";
        result += "<tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>\n";
        for (PerformanceData perf : data.performances()) {
            // 청구 내역을 출력한다.
            result += " <tr><td>" + perf.play().name() + "</td><td>" + usd(perf.amount()) + "(" + perf.audience() + "석)</td>\n";
            result += "<td>" + usd(perf.amount()) + "</td></tr>\n";
        }

        result += "</table>\n";
        result += "<p>총액: <em>" + usd(data.totalAmount()) + "</em></p>\n";
        result += "<p>적립 포인트: <em>" + data.totalVolumeCredits() + "</em>점</p>\n";
        return result;
    }

    private String usd(double aNumber) {
        return NumberFormat.getCurrencyInstance(Locale.US)
                .format(aNumber / 100.0);
    }

}
