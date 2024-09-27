package exercise3;

import static exercise3.Overload.sum;

public class Main {
    public static void main(String[] args) {
        // Call the overloaded methods and display the results
        int result1 = sum(10, 20);                  // Calls method with two int parameters
        int result2 = sum(5, 15, 25);               // Calls method with three int parameters
        double result3 = sum(12.5, 7.5);            // Calls method with two double parameters

        // Display the results
        System.out.println("Sum of 10 and 20 = " + result1);          // 30
        System.out.println("Sum of 5, 15, and 25 = " + result2);      // 45
        System.out.println("Sum of 12.5 and 7.5 = " + result3);       // 20.0
    }
}
