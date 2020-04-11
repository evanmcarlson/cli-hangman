import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hangman extends Game {

    abstract char getGuess();

    public Hangman(String playerID) {
        super(playerID);
    }

	public String randomPhrase() {
		// list of possible phrases
		String phraseList[] = {"university", "white pants", "los angeles", "backpack", "adventure", "european", "purple afro", "late night", "snacking", "filipino"};

		// choose phrase by random
		Random random = new Random();
		int x = random.nextInt(10);
		return phraseList[x];
	}

	public StringBuilder generateHiddenPhrase(String phrase) {
		// hide the phrase
		int i = 0;
		StringBuilder sb = new StringBuilder();

		while (i < phrase.length()) {
			if (Character.isLetter(phrase.charAt(i))) {
				sb.append("*");
			}
			else {
				sb.append(phrase.charAt(i));
			}
			i++;	
		}
		return sb;
	}

	public void processGuess(String phrase, StringBuilder hiddenPhrase, char guess) {
		// check guess against the phrase
		int q = 0;
		boolean isInPhrase = false;
		while (q < phrase.length()) {
			if (guess == phrase.charAt(q)) {
				hiddenPhrase.setCharAt(q, guess);
				isInPhrase = true;
			}
			q++;
		}

		if (isInPhrase == false) {
			System.out.println(guess + " is not in the phrase.");
		}
	}

	public ArrayList<String> readPhrases(String filename) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return list;
    }

    public void play(String phrase) {

        StringBuilder hiddenPhrase = generateHiddenPhrase(phrase);

        // print intro and hidden phrase
        System.out.println("Welcome to command line hangman. Each time you guess a letter, the hidden phrase will either reveal where that letter occurs in the phrase, or you will guess again. Good luck!");
        System.out.println(hiddenPhrase);

        // initialize variables
        boolean winner = false;
        StringBuilder previouslyGuessed = new StringBuilder();
        char guess;

        // THE GAME BEGINS
        while (winner == false) {

            guess = this.getGuess();

            // input validation
            boolean validated = false;

            while (validated == false) {
                if (Character.isLetter(guess)) {
                    validated = true;
                }
                else {
                    guess = this.getGuess();
                }
            }

            // ensure the guess hasn't been guessed previously
            boolean guessed = false;
            int y = 0;

            while (y < previouslyGuessed.length()) {
                if (guess == previouslyGuessed.charAt(y)) {
                    guessed = true;
                }
                y++;
            }

            previouslyGuessed.append(guess);

            //check guess
            if (guessed == false) {
                processGuess(phrase, hiddenPhrase, guess);
                this.score++;
                System.out.println(hiddenPhrase);
            }
            else {
                System.out.println("That letter was guessed previously. Please enter a new guess.");
            }

            // check for winner
            String sbToString = hiddenPhrase.toString();

            if (sbToString.contains("*") == false) {

                System.out.println("Congratulations! You won in " + this.score + " guesses");
                winner = true;
            }
        }
    }

	@Override
    public int compareTo(Object other) {
	    //lower scores are better, since we compare by numGuesses
	    Game otherGame = (Game) other;
        if (this.getScore() < otherGame.getScore()) {
            return 1;
        } else {
            if (this.getScore() == otherGame.getScore()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
