package alvarez.fernando.padroesprojetojava.domain.insurance.dto;

import java.util.ArrayList;
import java.util.List;

public class AnalysisResult {

    private int serasaScore;

    private final List<String> errors = new ArrayList<>();

    public int getSerasaScore() {
        return serasaScore;
    }

    public void setSerasaScore(int serasaScore) {
        this.serasaScore = serasaScore;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public boolean hasError() {
        return !this.errors.isEmpty();
    }

    public String printErrors() {
        if (this.errors.isEmpty()) {
            return "Nenhum";
        } else {
            final StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.errors.size(); i++) {
                stringBuilder.append("\t").append(i + 1).append("º: ").append(this.errors.get(i)).append("\n");
            }
            return stringBuilder.toString();
        }
    }

}
