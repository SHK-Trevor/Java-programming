package Exercise1;

public class Life extends Insurance {
    public Life(){

    }
    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Insurance Type: %s, Monthly Cost: $%.2f%n", getTypeOfInsurance(), getMonthlyCost());
    }
}