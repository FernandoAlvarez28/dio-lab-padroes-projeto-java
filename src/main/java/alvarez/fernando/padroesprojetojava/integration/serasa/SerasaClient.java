package alvarez.fernando.padroesprojetojava.integration.serasa;

import alvarez.fernando.padroesprojetojava.integration.serasa.impl.SerasaClientFakeImpl;

public interface SerasaClient {

    static SerasaClient getInstance() {
        return new SerasaClientFakeImpl();
    }

    int getScore(String document);

}
