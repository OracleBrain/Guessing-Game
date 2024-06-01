# Prodigy_SD_02
PRODIGY_SD_02

```markdown
# Guessing Game

This project is a simple guessing game where the program generates a random number, and the user tries to guess it. The game provides feedback on whether the user's guess is too high or too low and continues until the user correctly guesses the number. It also tracks the number of attempts and scores the user based on their performance.

## Features

- Generates a random number between a specified range (1 to 100).
- Prompts the user to guess the number and provides feedback.
- Tracks the number of attempts for each guess.
- Scores the user based on the number of attempts.
- Allows multiple rounds of guessing.

## How to Use

1. Clone this repository to your local machine:

    ```sh
    git clone https://github.com/OracleBrain/PRODIGY_SD_02.git
    ```

2. Navigate to the project directory:

    ```sh
    cd PRODIGY_SD_02
    ```

3. Compile the Java program:

    ```sh
    javac NumberGuessGame.java
    ```

4. Run the program:

    ```sh
    java NumberGuessGame
    ```

5. Follow the on-screen prompts to play the game. Enter your guesses and receive feedback on whether your guess is too high or too low. The game will continue until you guess the correct number.

## Example

```
Welcome to Guess the Number Game!
You have to guess a number between 1 and 100.

Round 1 of 3
Round Score: 0
Enter your guess: 50
Your guess is lower than the target number.
Enter your guess: 75
Your guess is higher than the target number.
Enter your guess: 60
Your guess is correct! You guessed the correct number in 3 attempts.
Round Score: 10

Round 2 of 3
Round Score: 10
Enter your guess: 30
Your guess is higher than the target number.
...
```

## Code Overview

```java
import java.util.Scanner;

class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int totalRounds = 3;
        int currentRound = 1;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("You have to guess a number between " + minRange + " and " + maxRange + ".");

        while (currentRound <= totalRounds) {
            int targetNumber = getRandomNumber(minRange, maxRange);
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("\nRound " + currentRound + " of " + totalRounds);
            System.out.println("Round Score: " + score);

            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    int roundScore = calculateRoundScore(attempts);
                    score += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    System.out.println("Your guess is higher than the target number.");
                }

                if (attempts >= maxAttempts) {
                    System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was: " + targetNumber);
                    break;
                }
            }

            currentRound++;
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + score);
        scanner.close();
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

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

- The `main` method initializes the game, handles user input, and controls the game flow across multiple rounds.
- The `getRandomNumber` method generates a random number within the specified range.
- The `calculateRoundScore` method determines the score for each round based on the number of attempts.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```

Feel free to customize this `README.md` file further to suit your specific project needs or preferences.
```