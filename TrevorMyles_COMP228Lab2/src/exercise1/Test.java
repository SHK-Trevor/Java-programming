package exercise1;

import java.util.Random;
import javax.swing.JOptionPane;

public class Test {
    private String[] questions = {
            "What is a \"collection of related objects\" called?\n1) Group\n2) Set\n3) Class\n4) Category",
            "What are instance variables?\n1) Variables that can be accessed from any class\n2) Variables that belong to a specific object of a class\n3) Variables that cannot change during the program\n4) Variables declared only in the main method",
            "What does the keyword \"private\" indicate when used with instance variables?\n1) They cannot be modified after declaration.\n2) They can be accessed from anywhere in the program.\n3) They are only accessible within the class where they are declared.\n4) They are accessible to all subclasses.",
            "What does the keyword \"void\" indicate in a method declaration?\n1) The method will return a value\n2) The method will not return any value\n3) The method requires parameters\n4) The method can be called without returning a value",
            "What are parameters in a method used for?\n1) To define the class name\n2) To pass values into the method\n3) To specify the types of instance variables\n4) To create local variables for all methods"
    };

    private int[] correctAnswers = {3, 2, 3, 2, 2};  // Correct answers
    private int correctCount = 0;
    private int incorrectCount = 0;
    private Random random = new Random();

    // Simulate a question
    public void simulateQuestion(int questionIndex) {
        String question = questions[questionIndex];
        String answerStr = JOptionPane.showInputDialog(null, question);
        try {
            int answer = Integer.parseInt(answerStr); // Convert the input to an integer
            checkAnswer(questionIndex, answer);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
        }
    }

    // Check if the user's answer is correct
    public void checkAnswer(int questionIndex, int answer) {
        int correctAnswer = correctAnswers[questionIndex];
        if (answer == correctAnswer) {
            correctCount++;
            JOptionPane.showMessageDialog(null, generateMessage(true));
        } else {
            incorrectCount++;
            JOptionPane.showMessageDialog(null, generateMessage(false) + " The correct answer is: " + correctAnswer);
        }
    }

    // Generate a random message based on correct/incorrect answer
    public String generateMessage(boolean isCorrect) {
        String message;
        int responseIndex = random.nextInt(4); // Random number between 0 and 3

        switch (responseIndex) {
            case 0:
                message = isCorrect ? "Excellent!" : "No. Please try again.";
                break;
            case 1:
                message = isCorrect ? "Good!" : "Wrong. Try once more.";
                break;
            case 2:
                message = isCorrect ? "Keep up the good work!" : "Don't give up!";
                break;
            default:
                message = isCorrect ? "Nice work!" : "No. Keep trying..";
                break;
        }

        return message;
    }

    // Method to input answers and simulate the test
    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {
            simulateQuestion(i);
        }

        displayResult();
    }

    // Display the final result of the test
    public void displayResult() {
        int totalQuestions = questions.length;
        double percentage = ((double) correctCount / totalQuestions) * 100;

        JOptionPane.showMessageDialog(null, "Test Completed!\n" +
                "Correct Answers: " + correctCount + "\n" +
                "Incorrect Answers: " + incorrectCount + "\n" +
                "Percentage: " + String.format("%.2f", percentage) + "%");
    }
}
