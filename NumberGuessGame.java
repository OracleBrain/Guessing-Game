```java
import java.util.Scanner; // Import the Scanner class for user input

/**
 * This program is a simple Number Guessing Game.
 * The player has to guess a number between 1 and 100.
 * The game consists of multiple rounds, and the player's score is based on the number of attempts taken to guess the correct number.
 *
 * The program performs the following steps:
 * 1. Sets the range for the random number (1 to 100).
 * 2. Defines the total number of rounds and initializes the current round and score.
 * 3. Prompts the player to guess the number within a specified number of attempts.
 * 4. Provides feedback if the guess is too high or too low.
 * 5. Calculates and displays the score for each round.
 * 6. Displays the total score after all rounds are completed.
 *
 * Author: Aashis Jha
 */
class NumberGuessGame {

    public static void main(String[] args) {
        // Create a Scanner object for taking user input
        Scanner scanner = new Scanner(System.in);
        
        // Define the range for the random number
        int minRange = 1;
        int maxRange = 100;
        
        // Define the total number of rounds and initialize the current round and score
        int totalRounds = 3;
        int currentRound = 1;
        int score = 0;
        
        // Display introductory messages
        System.out.println("TASK 02");
        System.out.println("The program is represented by Aashis Jha");
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("You have to guess a number between 1 and 100.");

        // Loop through each round of the game
        while (currentRound <= totalRounds) {
            // Generate a random number for the current round
            int targetNumber = getRandomNumber(minRange, maxRange);
            int attempts = 0;
            int maxAttempts = 10; // Maximum attempts allowed per round

            System.out.println("\nRound " + currentRound + " of " + totalRounds);
            System.out.println("Current Score: " + score);

            // Loop for the player to make guesses
            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                // Check if the guess is correct
                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    int roundScore = calculateRoundScore(attempts);
                    score += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guess < targetNumber) {
                    // Feedback if the guess is lower than the target number
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    // Feedback if the guess is higher than the target number
                    System.out.println("Your guess is higher than the target number.");
                }

                // Check if the player has reached the maximum number of attempts
                if (attempts >= maxAttempts) {
                    System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was: " + targetNumber);
                    break;
                }
            }

            // Move to the next round
            currentRound++;
        }

        // Display the final score and end the game
        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + score);
        scanner.close(); // Close the Scanner object
    }

    /**
     * Generates a random number within the specified range.
     *
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random number between min and max (inclusive).
     */
    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Calculates the score for the round based on the number of attempts.
     * More points are awarded for fewer attempts.
     *
     * @param attempts The number of attempts taken to guess the correct number.
     * @return The score for the round.
     */
    private static int calculateRoundScore(int attempts) {
        if (attempts <= 3) {
            return 10;
        } else if (attempts <= 6) {
            return 5;
        } else {
            return 1;
        }
    }
}
```