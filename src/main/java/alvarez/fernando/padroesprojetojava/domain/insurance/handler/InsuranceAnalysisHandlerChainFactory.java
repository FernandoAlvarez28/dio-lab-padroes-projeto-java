package alvarez.fernando.padroesprojetojava.domain.insurance.handler;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.AnalysisResult;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.InsuranceOrder;
import alvarez.fernando.padroesprojetojava.domain.insurance.handler.impl.*;
import alvarez.fernando.padroesprojetojava.handler.HandlerChain;

public class InsuranceAnalysisHandlerChainFactory {

    private static final InsuranceAnalysisHandlerChainFactory INSTANCE = new InsuranceAnalysisHandlerChainFactory();

    private InsuranceAnalysisHandlerChainFactory() {}

    public static InsuranceAnalysisHandlerChainFactory getInstance() {
        return INSTANCE;
    }

    public HandlerChain<InsuranceOrder, AnalysisResult> createChain() {
        return new HandlerChain<>(
                new AgeInsuranceHandlerImpl()
                , new MonthlyIncomeInsuranceHandlerImpl()
                , new SerasaScoreInsuranceHandlerImpl()
                , new InsuranceValidationHandlerImpl()
                , new InsuranceCreationHandlerImpl()
        );
    }

}
