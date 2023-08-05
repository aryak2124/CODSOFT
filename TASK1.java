import java.util.Scanner;
import java.util.Random;
public class TASK1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int score = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + minNumber + " and " + maxNumber + ".");
        do {
            int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            int guess;
            System.out.println("New round started. Try to guess the number!");
            while (true) {
                attempts++;
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }
            score++;
            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (y/n): ");
        } while (scanner.next().equalsIgnoreCase("y"));
        System.out.println("Thanks for playing! Your final score: " + score);
    }
}

