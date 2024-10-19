package Exercise3;

public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageNumber, String customerName, double amount, int term) {
        super();
    }

    @Override
    protected double setInterestRate() {
        double primeRate = 0.03;
        return primeRate + 0.01; // 1% over the prime rate
    }
}
