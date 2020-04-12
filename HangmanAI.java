import java.util.ArrayList;

public class HangmanAI extends Hangman {
    private int index = 0;
    private String guesses = "aeioundtlbcdfghjkmpqrsuvwxyz";
    private int i = 0;

    StringBuilder phrase;

    public HangmanAI(String playerID) {
        super(playerID);
        this.phrase = this.generateHiddenPhrase(this.randomPhrase());
    }

    char getGuess() {
        char guess = guesses.charAt(index);
        index++;

        while (i < phrase.length()) {
            //one letter word
            if (this.phrase.charAt(i) == ' ' && phrase.charAt(i+2) == ' ' ) {
                guess = 'i';
            }

            // words that end in -ing
            if ( phrase.charAt(i) == 'i' && phrase.charAt(i+1) == 'n' ) {
                guess = 'g';
            }
            if (phrase.charAt(i) == 'i' && phrase.charAt(i+2) == 'g') {
                guess = 'n';
            }

            // special common rules
            if (phrase.charAt(i) == 'c') {
                guess = 'k';
            }

            i++;
        }

        return guess;
    }

    public static void main(String[] args) {
        GamesRecord record = new GamesRecord();
        HangmanAI player = new HangmanAI("Game 1");
        ArrayList<String> phraseList = player.readPhrases("hangPhrases.txt");

        int i = 0;
        while (i < phraseList.size()) {
            player.play(phraseList.get(i));
            record.add(player);
            i++;
            player = new HangmanAI("Game " + Integer.toString(i));
        }
        System.out.printf("%s", record);
        System.out.println("Average guesses: " + record.average());
    }
}
