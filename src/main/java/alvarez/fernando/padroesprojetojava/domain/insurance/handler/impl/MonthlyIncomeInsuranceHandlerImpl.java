package alvarez.fernando.padroesprojetojava.domain.insurance.handler.impl;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.AnalysisResult;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.InsuranceOrder;
import alvarez.fernando.padroesprojetojava.handler.Handler;
import alvarez.fernando.padroesprojetojava.handler.HandlerChain;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class MonthlyIncomeInsuranceHandlerImpl implements Handler<InsuranceOrder, AnalysisResult> {

    private static final BigDecimal MINIMUM_INCOME = new BigDecimal("1600.00");

    @Override
    public void handleNext(HandlerChain<InsuranceOrder, AnalysisResult> handlerChain, InsuranceOrder input, AnalysisResult output) {
        final BigDecimal monthlyIncome = input.requester().monthlyIncome();

        if (monthlyIncome == null) {
            output.addError("É necessário informar sua renda mensal!");
        } else if (monthlyIncome.compareTo(MINIMUM_INCOME) < 0) {
            final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            output.addError("Sua renda mensal é menor que o mínimo de " + currencyInstance.format(MINIMUM_INCOME) + ": " + currencyInstance.format(monthlyIncome));
        }

        handlerChain.next(input, output);
    }

}
