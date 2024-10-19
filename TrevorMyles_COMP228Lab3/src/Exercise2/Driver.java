package Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<GameTester>Info = new ArrayList<>();

        System.out.println("Choose one of the type of Game Tester");
        System.out.println("1. Full-Time Game Tester");
        System.out.println("2. Part-Time Game Tester");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the full name of the Game Tester: ");
        String name = scanner.nextLine();

        GameTester tester = null;

        if (choice == 1) {
            tester = new FullTimeGameTester(name);
        } else if (choice == 2) {
            System.out.print("Enter the number of hours worked: ");
            int hoursWorked = scanner.nextInt();
            tester = new PartTimeGameTester(name, hoursWorked);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println(tester.Name() + "'s salary: $" + tester.salary());
        scanner.close();
    }
}
