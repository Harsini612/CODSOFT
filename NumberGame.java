import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;
        System.out.print("\033c");
        

        while (playAgain) {
            totalRounds++;
            int attempts = playRound(sc);
            totalAttempts += attempts;
            playAgain = askToPlayAgain(sc);
        }

        double averageAttempts = (double) totalAttempts / totalRounds;
        System.out.printf("Game Over! You played %d rounds with a total of %d attempts.%n", totalRounds, totalAttempts);
        System.out.printf("Average attempts per round: %.2f%n", averageAttempts);
    }
    
    private static int playRound(Scanner sc) {
        Random random = new Random();
        int number = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
        int attempts = 0;
        System.out.print("--------------------NUMBER GAME--------------------------");
        System.out.println();
        System.out.println("Enter your Name:");
        String s=sc.next();
        System.out.println("Hello "+s+",Let's Start!!");
        
        System.out.println("I've picked a number between " + RANGE_START + " and " + RANGE_END + ". Can you guess it?");
        while (attempts < MAX_ATTEMPTS)
        {
            System.out.printf("Attempt %d/%d: Your guess? ", attempts + 1, MAX_ATTEMPTS);
            int guess = sc.nextInt();
            attempts++;
            if (guess < number){
                System.out.println("Too low! Try again.");
            } 
            else if (guess > number){
                System.out.println("Too high! Try again.");
            } 
            else{
                System.out.printf("Congratulations! You guessed the correct number %d in %d attempts.%n", number, attempts);
                return attempts;
            }
        }
        System.out.printf("Sorry, you've used all %d attempts. The number was %d.%n", MAX_ATTEMPTS, number);
        return attempts;
    }

    private static boolean askToPlayAgain(Scanner sc) {
        System.out.print("Do you want to play again? (Yes/No): ");
        String response = sc.next();
        return response.equalsIgnoreCase("Yes");
    }
}