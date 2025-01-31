package ch01;

import java.util.List;

public record StatementData(String customer, List<Performance> performances) {
}
