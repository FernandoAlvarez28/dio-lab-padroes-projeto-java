package alvarez.fernando.padroesprojetojava.domain.insurance.handler.impl;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.AnalysisResult;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.InsuranceOrder;
import alvarez.fernando.padroesprojetojava.handler.Handler;
import alvarez.fernando.padroesprojetojava.handler.HandlerChain;
import alvarez.fernando.padroesprojetojava.integration.serasa.SerasaClient;

public class SerasaScoreInsuranceHandlerImpl implements Handler<InsuranceOrder, AnalysisResult> {

    private static final int MINIMUM_SCORE = 700;

    @Override
    public void handleNext(HandlerChain<InsuranceOrder, AnalysisResult> handlerChain, InsuranceOrder input, AnalysisResult output) {
        final int serasaScore = SerasaClient.getInstance().getScore(input.requester().document());

        output.setSerasaScore(serasaScore);

        if (serasaScore < MINIMUM_SCORE) {
            output.addError("Seu score é menor que " + MINIMUM_SCORE + ": " + serasaScore);
        }

        handlerChain.next(input, output);
    }
}
