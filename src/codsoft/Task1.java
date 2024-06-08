package codsoft;/*TASK 1
        1. Generate a random number within a specified range, such as 1 to 100.
        2. Prompt the user to enter their guess for the generated number.
        3. Compare the user's guess with the generated number and provide feedback on whether the guess
        is correct, too high, or too low.
        4. Repeat steps 2 and 3 until the user guesses the correct number.
        You can incorporate additional details as follows:
        5. Limit the number of attempts the user has to guess the number.
        6. Add the option for multiple rounds, allowing the user to play again.
        7. Display the user's score, which can be based on the number of attempts taken or rounds won.
        NUMBER GAME
*/



import java.util.Random;
import java.util.Scanner;

public class Task1 {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A new game has started! Guess the number between 1 and 100.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + randomNumber);
            }

            System.out.println("You took " + attempts + " attempts.");
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye.");
    }
}



