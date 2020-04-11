# cli-hangman
A simple command line version of the game Hangman that supports two modes: user and AI. 

First choose if you would like an AI model to play or if you would like to play.
To play the game in user mode, simply download the code and open a terminal in the location of the file. Type `javac HangmanUser.java` to compile the code, and `java HangmanUser` to play.
To play the game in AI mode, simply download the code and open a terminal in the location of the file. Type `javac HangmanAI.java` to compile the code, and `java HangmanAI` to play. Note that this mode of playing requires the creation of a file hangPhrases.txt in the same directory which contains one hangman phrase on each line for the AI model to play.

The game begins by randomly selecting one of ten phrases and replacing all letter with an asterik (*). Spaces and punctuation are left unhidden.

The user guesses a letter. All occurrences of the letter in the phrase are replaced in the partially hidden phrase.

The phrases and guesses may include lowercase, uppercase letters and digits. If a guess is not a letter or digit (e.g., ‘%’) the user will be notified but not penalized a miss. If the guessed letter does not occur in the phrase, the user is notified of the miss and how many misses/chances are left.

If the user misses 8 times, they lose and the game is over. If all letters in the phrase are guessed, the user wins!
