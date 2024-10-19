package Exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public void Mortgage(String mortgageNumber, String customerName, double amount, int term) {
        if (amount > maxmortageamount) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed " + maxmortageamount);
        }
    }

    protected abstract double setInterestRate();

    public double totalAmountOwed() {
        return amount + (amount * interestRate * term);
    }

    public String getMortgageInfo() {
        return String.format("Mortgage Number: %s\n" +
                            "Customer Name: %s\n" +
                            "Amount: %.2f\n" +
                            "Interest Rate: %.2f%%\n" +
                            "Term: %d years\n" +
                            "Total Amount Owed: %.2f",
                mortgageNumber, customerName, amount, interestRate * 100, term, totalAmountOwed());
    }
}