package alvarez.fernando.padroesprojetojava.integration.serasa.impl;

import alvarez.fernando.padroesprojetojava.integration.serasa.SerasaClient;

import java.util.Random;

public class SerasaClientFakeImpl implements SerasaClient {

    private final Random random = new Random();

    private final float positiveScoreMinimumChance;

    public SerasaClientFakeImpl() {
        this(0.8f);
    }

    public SerasaClientFakeImpl(float positiveScoreMinimumChance) {
        this.positiveScoreMinimumChance = positiveScoreMinimumChance;
    }

    @Override
    public int getScore(String document) {
        double positiveScoreChance = random.nextDouble();

        if (positiveScoreChance < this.positiveScoreMinimumChance) {
            return random.nextInt(301) + 700;
        } else {
            return random.nextInt(701);
        }
    }
}
