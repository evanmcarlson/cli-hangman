import java.util.Random;
import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		// list of possible phrases
		String phraseList[] = {"university", "white pants", "los angeles", "backpack", "adventure", "european", "purple afro", "late night", "snacking", "filipino"};

		// choose phrase by random
		Random random = new Random();
		int x = random.nextInt(10);
		String phrase = phraseList[x];

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

		// print intro and hidden phrase
		System.out.println("Welcome to command line hangman. If you guess incorecctly eight times, you lose. Each time you guess a letter, the hidden phrase will either reveal where that letter occurs in the phrase, or you will lose a life. Good luck!");
		System.out.println(sb);

		// initialize variables
		boolean winner = false;
		int lives = 8;
		StringBuilder previouslyGuessed = new StringBuilder();

		// THE GAME BEGINS
		while (winner == false) {
			while (lives > 0) {
				System.out.println(lives + " lives remaining.");

				// recieve guess from user
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter a guess: ");
				char guess = scanner.next(".").charAt(0);

				// input validation
				boolean validated = false;

				while (validated == false) {
					if (Character.isLetter(guess)) {
						validated = true;
					}
					else {
						System.out.println("The character you entered is not valid. Please enter letters only.");
						System.out.print("Enter a guess: ");
						guess = scanner.next(".").charAt(0);
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

				// check guess against the phrase
				int q = 0;
				boolean isInPhrase = false;

				if (guessed == false) {
					while (q < phrase.length()) {
						if (guess == phrase.charAt(q)) {
							sb.setCharAt(q, guess);
							isInPhrase = true;
						}
						q++;
					}

					if (isInPhrase == false) {
						lives--;
					}

					System.out.println(sb);
				}
				else {
					System.out.println("That letter was guessed previously. Please enter a new guess.");
				}

				// check for winner
				String sbToString = sb.toString();

				if (sbToString.contains("*") == false) {
					System.out.println("Congratulations! You win.");
					winner = true;
					break;
				}
			}
			// if user runs out of lives
			if (winner == false) {
				System.out.println("Sorry, you ran out of lives. You lose.");
				System.out.println("The hidden phrase was: " + phrase);
				break;
			}
		}
	}
}