import  java.util.Scanner;
import java.util.Random;
public class Rps {
        public static void main(String[] args) {

            String[] choices = { "Rock" , "Paper" , "Scissors" };

            Scanner sc = new Scanner(System.in);

            Random rd = new Random();

            while (true) {

                int computerChoiceIndex = rd.nextInt(3);
                String computerChoice = choices[computerChoiceIndex];
                System.out.println("LETS START OUR GAME");
                System.out.print("Enter your choice (Rock, Paper, or Scissors): ");
                String userChoice = sc.next();

                if (!isValidChoice(userChoice)) {
                    System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                    continue;
                }

                String result = determineWinner(userChoice, computerChoice);

                System.out.println("Computer chose: " + computerChoice);
                System.out.println(result);

                System.out.print("Play again? (yes/no): ");
                String playAgain = sc.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                }
            }

            sc.close();
        }

        public static boolean isValidChoice(String choice) {
            return choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("Paper") || choice.equalsIgnoreCase("Scissors");
        }

        public static String determineWinner(String userChoice, String computerChoice) {
            if (userChoice.equalsIgnoreCase(computerChoice)) {
                return "It's a tie!";
            } else if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
                    (userChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
                    (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))) {
                return "You win!";
            } else {
                return "Computer wins!";
            }
        }
    }

