import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // number from 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    score += (10 - attempts); // scoring logic
                    guessedCorrectly = true;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("📉 Too high!");
                } else {
                    System.out.println("📈 Too low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n🏁 Game Over! Your final score is: " + score);
        sc.close();
    }
}
