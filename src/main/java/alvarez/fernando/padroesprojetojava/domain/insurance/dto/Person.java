package alvarez.fernando.padroesprojetojava.domain.insurance.dto;

import java.math.BigDecimal;

public record Person(
        String name,
        String document,
        int age,
        BigDecimal monthlyIncome
) {
}
