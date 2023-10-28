package alvarez.fernando.padroesprojetojava.domain.insurance.repository.impl;

import alvarez.fernando.padroesprojetojava.domain.insurance.model.Insurance;
import alvarez.fernando.padroesprojetojava.domain.insurance.repository.InsuranceRepository;

public class InsuranceRepositoryFakeImpl implements InsuranceRepository {
    @Override
    public void save(Insurance insurance) {
        System.out.println("Insurance saved: " + insurance);
    }
}
