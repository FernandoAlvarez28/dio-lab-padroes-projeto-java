package alvarez.fernando.padroesprojetojava.domain.insurance.repository;

import alvarez.fernando.padroesprojetojava.domain.insurance.model.Insurance;
import alvarez.fernando.padroesprojetojava.domain.insurance.repository.impl.InsuranceRepositoryFakeImpl;

public interface InsuranceRepository {

    static InsuranceRepository getInstance() {
        return new InsuranceRepositoryFakeImpl();
    }

    void save(Insurance insurance);

}
