package alvarez.fernando.padroesprojetojava.domain.insurance.handler.impl;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.AnalysisResult;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.InsuranceOrder;
import alvarez.fernando.padroesprojetojava.domain.insurance.model.Insurance;
import alvarez.fernando.padroesprojetojava.domain.insurance.repository.InsuranceRepository;
import alvarez.fernando.padroesprojetojava.handler.Handler;
import alvarez.fernando.padroesprojetojava.handler.HandlerChain;

public class InsuranceCreationHandlerImpl implements Handler<InsuranceOrder, AnalysisResult> {

    @Override
    public void handleNext(HandlerChain<InsuranceOrder, AnalysisResult> handlerChain, InsuranceOrder input, AnalysisResult output) {
        if (output.hasError()) {
            return;
        }

        final Insurance insurance = new Insurance(input.requester());

        InsuranceRepository.getInstance().save(insurance);

        handlerChain.next(input, output);
    }

}
