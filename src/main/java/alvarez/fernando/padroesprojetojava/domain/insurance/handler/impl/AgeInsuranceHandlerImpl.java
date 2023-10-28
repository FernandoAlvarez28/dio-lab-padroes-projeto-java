package alvarez.fernando.padroesprojetojava.domain.insurance.handler.impl;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.AnalysisResult;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.InsuranceOrder;
import alvarez.fernando.padroesprojetojava.handler.Handler;
import alvarez.fernando.padroesprojetojava.handler.HandlerChain;

public class AgeInsuranceHandlerImpl implements Handler<InsuranceOrder, AnalysisResult> {

    private static final int MINIMUM_AGE = 18;

    private static final int MAXIMUM_AGE = 90;

    @Override
    public void handleNext(HandlerChain<InsuranceOrder, AnalysisResult> handlerChain, InsuranceOrder input, AnalysisResult output) {
        final int age = input.requester().age();

        if (age < MINIMUM_AGE) {
            output.addError("Sua idade é menor que " + MINIMUM_AGE + ": " + age);
        } else if (age > MAXIMUM_AGE) {
            output.addError("Sua idade é maior que " + MAXIMUM_AGE + ": " + age);
        }

        handlerChain.next(input, output);
    }
}
