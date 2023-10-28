package alvarez.fernando.padroesprojetojava.domain.insurance.handler.impl;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.AnalysisResult;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.InsuranceOrder;
import alvarez.fernando.padroesprojetojava.handler.Handler;
import alvarez.fernando.padroesprojetojava.handler.HandlerChain;

public class InsuranceValidationHandlerImpl implements Handler<InsuranceOrder, AnalysisResult> {

    @Override
    public void handleNext(HandlerChain<InsuranceOrder, AnalysisResult> handlerChain, InsuranceOrder input, AnalysisResult output) {
        if (output.hasError()) {
            System.out.println("Erros encontrados:\n" + output.printErrors());
        } else {
            handlerChain.next(input, output);
        }
    }

}
