package exercise2;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Arrays;

public class Lotto {
    // Array to hold three random integer values
    private int[] numbers;

    // Constructor to initialize the array with random values from 1 to 9
    public Lotto() {
        numbers = new int[3];  // Array to hold 3 numbers
        Random rand = new Random();

        // Populate array with random numbers between 1 and 9
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(9) + 1;  // Random number between 1 and 9
        }
    }

    // Method to return the lotto numbers as an array
    public int[] getNumbers() {
        return numbers;
    }

    // Method to compare user guesses with lotto numbers
    public boolean checkGuess(int[] userGuess) {
        return Arrays.equals(userGuess, numbers);  // Check if arrays are equal
    }
}
