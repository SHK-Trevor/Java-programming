package Exercise3;
import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];
        int mortgageCount = 0;

        System.out.print("Enter the current interest rate (in decimal): ");
        double currentInterestRate = scanner.nextDouble(); // not used but captured for understanding

        for (int i = 0; i < mortgages.length; i++) {
            System.out.print("Enter mortgage type (1 for Business, 2 for Personal): ");
            int type = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter mortgage number: ");
            String mortgageNumber = scanner.nextLine();

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter mortgage amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter mortgage term (1 for Short, 3 for Medium, 5 for Long): ");
            int term = scanner.nextInt();

            if (type == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, term);
            } else {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, term);
            }
        }

        System.out.println("\nMortgages Information:");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println("--------------------------------------");
        }

        scanner.close();
    }
}
