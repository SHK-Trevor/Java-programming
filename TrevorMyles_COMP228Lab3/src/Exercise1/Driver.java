package Exercise1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Insurance> insuranceInformation = new ArrayList<>();

        while (true) {
            System.out.println("Enter the type of insurance (health/life) or 'exit' to finish:");
            String type = scanner.nextLine().trim().toLowerCase();

            if (type.equals("exit")) {
                break;
            }

            System.out.println("Enter the monthly fee:");
            double fee = Double.parseDouble(scanner.nextLine().trim());

            Insurance insurance = null;
            if (type.equals("health")) {
                insurance = new Health();
            } else if (type.equals("life")) {
                insurance = new Life();
            } else {
                System.out.println("Invalid insurance type. Please enter 'health' or 'life'.");
                continue;
            }

            insurance.setInsuranceCost(fee);
            insuranceInformation.add(insurance);
            System.out.println("Insurance added.");
        }

        System.out.println("\nInsurance Information:");
        for (Insurance ins : insuranceInformation) {
            ins.displayInfo();
        }

        scanner.close();
    }
}
