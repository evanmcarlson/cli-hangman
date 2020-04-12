import java.util.Scanner;

public class HangmanUser extends Hangman {

    public  HangmanUser(String playerID) {
        super(playerID);
    }

    public char getGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your next guess: ");
        char guess = scanner.next().charAt(0);
        return guess;
    }

    public static void main(String[] args) {
        GamesRecord record = new GamesRecord();
        boolean done = false;
        Scanner scanner = new Scanner(System.in);

        while (!done) {
            //create a user object and play a single game
            System.out.println("Please enter your player ID: ");
            String playerID = scanner.next();
            HangmanUser player = new HangmanUser(playerID);

            String phrase = player.randomPhrase();
            player.play(phrase);

            record.add(player);

            System.out.println("Would you like to play again? (y/n)");
            char replay = scanner.next().charAt(0);
            if (replay == 'n') {
                break;
            }
        }
        System.out.printf("%s", record);
        System.out.println("Average guesses: " + record.average());
    }
}
