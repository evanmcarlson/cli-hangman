# cli-hangman
This repository contains two programs: HangmanUser and HangmanAI. They are simple command line versions of the game hangman that support user mode and AI (scripting) mode, respectively.

HangmanUser is an interactive game of hangman populated with predetermined phrases where you guess each letter. 

HangmanAI is a non interactive game of hangman- it is somewhat reminiscent of a HangmanUser scripting mode. This mode is NOT populated with predetmined phrases and instead requires a file-hangPhrases.txt-containing phrases seperated by a newline character (a sample is included).

### getting started
To play the game in user mode, download the code and open a terminal in the location of the file. Type `javac HangmanUser.java` to compile the code, and `java HangmanUser` to play.

To play the game in AI mode, download the code and open a terminal in the location of the file. Type `javac HangmanAI.java` to compile the code, and `java HangmanAI` to play.

### theory and rules
The game begins by randomly selecting one of ten phrases and replacing all letter with an asterik (*). Spaces and punctuation are left unhidden.

The user guesses a letter. All occurrences of the letter in the phrase are replaced in the partially hidden phrase.

The phrases and guesses may include lowercase, uppercase letters and digits. If a guess is not a letter or digit (e.g., ‘%’) the user will be notified but not penalized a miss. If the guessed letter does not occur in the phrase, the user is notified of the miss and how many misses/chances are left.

If the user misses 8 times, they lose and the game is over. If all letters in the phrase are guessed, the user wins!
