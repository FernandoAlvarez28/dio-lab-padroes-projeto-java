package alvarez.fernando.padroesprojetojava;

import alvarez.fernando.padroesprojetojava.domain.insurance.dto.AnalysisResult;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.InsuranceOrder;
import alvarez.fernando.padroesprojetojava.domain.insurance.dto.Person;
import alvarez.fernando.padroesprojetojava.domain.insurance.handler.InsuranceAnalysisHandlerChainFactory;
import alvarez.fernando.padroesprojetojava.handler.HandlerChain;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo!\n\n");

        System.out.print("Primeiro, informe seu nome: ");
        final String personName = scanner.next();

        System.out.print("Agora, informe seu CPF: ");
        final String personDocument = scanner.next();

        System.out.print("Sua idade: ");
        final int personAge = scanner.nextInt();

        System.out.print("Sua renda mensal: ");
        final double personMonthlyIncome = scanner.nextDouble();

        final Person person = new Person(personName, personDocument, personAge, new BigDecimal(personMonthlyIncome));

        final InsuranceOrder insuranceOrder = new InsuranceOrder(person);

        final HandlerChain<InsuranceOrder, AnalysisResult> insuranceHandlerChain = InsuranceAnalysisHandlerChainFactory.getInstance().createChain();

        final AnalysisResult analysisResult = new AnalysisResult();
        insuranceHandlerChain.next(insuranceOrder, analysisResult);


    }
}
