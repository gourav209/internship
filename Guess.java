import java.util.*;
public class Guess {
    public static void guessingNumberGame()
        {
            // Scanner Class
            Scanner sc = new Scanner(System.in);

            // Generate the numbers
            Random number=new Random();

            int x = number.nextInt(50);

            // Given K trials
            int K = 5;
            int i,guess;
            System.out.println("Guess the number within 5 trials");

            // Iterate over K Trials
            for (i = 0; i < K; i++) {

                System.out.println("Guess the number:");

                // Take input for guessing
                guess = sc.nextInt();

                // If the number is guessed
                if (x == guess) {
                    System.out.println("Congratulations!" + " You guessed the number.");
                    break;
                }
                else if (x > guess && i != K - 1) {
                    System.out.println("The number is " + "greater than " + guess);
                }
                else if (x < guess && i != K - 1) {
                    System.out.println("The number is" + " less than " + guess);
                }
            }

            if (i == K) {
                System.out.println("You have exhausted" +K+" trials.");

                System.out.println("The number was " + number);
            }
        }

        // Driver Code
        public static void main(String arg[])
        {

            guessingNumberGame();
        }
    }


