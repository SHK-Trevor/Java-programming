package exercise2;

import javax.swing.*;

public class Main {
    // Main method to run the lotto game
    public static void main(String[] args) {
        // Create a Lotto object
        Lotto lotto = new Lotto();

        // Get the lotto numbers (this will not be shown to the user)
        int[] lottoNumbers = lotto.getNumbers();

        // Initialize the attempt counter
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;  // Limit to 5 attempts
        boolean isCorrect = false;

        // Loop until the user guesses correctly or runs out of attempts
        while (!isCorrect && attempts < MAX_ATTEMPTS) {
            // Get user input
            String input = JOptionPane.showInputDialog(null, "Attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + ": Enter 3 numbers between 1 and 9 separated by spaces:");

            // Split the input and convert to an integer array
            String[] inputStrings = input.split(" ");
            int[] userGuess = new int[3];

            // Ensure the input is valid (3 numbers, within range)
            try {
                for (int i = 0; i < 3; i++) {
                    userGuess[i] = Integer.parseInt(inputStrings[i]);
                    if (userGuess[i] < 1 || userGuess[i] > 9) {
                        throw new NumberFormatException("Numbers must be between 1 and 9.");
                    }
                }

                // Check if the user's guess matches the lotto numbers
                isCorrect = lotto.checkGuess(userGuess);

                if (isCorrect) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct numbers: " + lottoNumbers[0] + ", " + lottoNumbers[1] + ", " + lottoNumbers[2]);
                } else {
                    attempts++;  // Increment the attempt counter
                    if (attempts < MAX_ATTEMPTS) {
                        JOptionPane.showMessageDialog(null, "Incorrect guess. You have " + (MAX_ATTEMPTS - attempts) + " attempts left.");
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter 3 numbers between 1 and 9 separated by spaces.");
            }
        }

        // If the user used all attempts and didn't guess correctly
        if (!isCorrect && attempts == MAX_ATTEMPTS) {
            JOptionPane.showMessageDialog(null, "Sorry, you've used all 5 attempts! The correct numbers were: " + lottoNumbers[0] + ", " + lottoNumbers[1] + ", " + lottoNumbers[2]);
        }
    }

}
