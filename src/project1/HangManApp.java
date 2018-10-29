package project1;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
The program randomly selects a word from a hard-coded list of possible words. Then
the game begins.
2. For each round of the game…
a. The word is displayed with guessed letters showing and unguessed letters
represented by underscores. Additionally a count of misses is displayed.
b. The user enters a single letter. (Make sure to validate their input.)
c. If the word contains the guessed letter, reveal every place that letter is found in
the word.
d. If the word does not contain the guessed letter. Add one to a count of misses.
3. The rounds continue until either the entire word is revealed or the user runs out of
misses. (You choose how many misses they’re allowed.)
 */



public class HangManApp {
	public static void main(String[] args) {
		
//	Delcaring Variables used.
		Scanner scnr = new Scanner(System.in);
		int turn;
		boolean hangman = false;
		String letter;
		String words;
		String hide;
		String word;
		boolean playAgain = true;
		
		System.out.println("Let's play Hangman"); // Advises the user that we are going to play Hangman
		
		// The do/while loop will allow the game to run, while the user keeps selected yes to playAgain. 
		do {
			
			word = generateRandomWord();  // calls method at end of code to run RandomGenerator for List of words in method.
			
			hide = word.replaceAll("[A-Za-z]", "_");  //hides the characters fo the word, so the user cannot see the word to play the game. 
			
			hangman = false;  // resets variables for new game
			turn = 10;  // resets variables for new game
			
			System.out.println("Random word selected: " + hide);
			System.out.println("This word contains " + word.length() + " characters");

			//  This while loop, runs inside the Do-While and is not to be confused with the while condition that ends the Do-While Loop.
			// Loops through Game play in the same Game.
			while (hangman == false) {
				System.out.println("Turns remaining: " + turn);
				System.out.println("Please choose a letter A-Z :");
				String ChosenLetter = scnr.next();
				if (word.contains(ChosenLetter)) {
					System.out.println("You have chosen correctly: ");
					char[] cword = word.toCharArray();
					char[] chide = hide.toCharArray();
					for (int i = 0; i < cword.length; i++) {
						if (cword[i] == ChosenLetter.charAt(0)) {
							chide[i] = cword[i];
						}
					}
					hide = new String(chide); // Load new hide into String
					System.out.println("Yes!" + hide); // Prints hide after Yes!
					turn--;
				} else {
					System.out.println("WRONG!, Try again!" + hide); // Prints hide after No!
					turn--;
				}

				if (hide.equals(word)) {
					System.out.println("Correct! You win! The word was " + word);  //Prompts user they have won, also sets Hangman to True, stops the while loop inside the Do-while
					hangman = true;
				}

				if (turn == 0) { //Prompts user they have lost, also sets Hangman to True, stops the while loop inside the Do-while
					hangman = true;

					System.out.println("You lost!");  
				}

				if (hangman == true) { // Game is over prompts the user to Loop the Do - while to restart the game. 

					System.out.println("Do you want to play again?");
					String userResponse = scnr.next();

					if (userResponse.equals("yes")) {

						playAgain = true;
					} else {
						playAgain = false;
					}
				}

			}

		} while (playAgain);  // End of Do-While

	}

		// Method that enables List of Random Words for our hangman game.
	private static String generateRandomWord() {
		String[] words = new String[10];
		words[0] = "Grand";
		words[1] = "Circus";
		words[2] = "Tim";
		words[3] = "David";
		words[4] = "Java";
		words[5] = "Roshambo";
		words[6] = "Coffee";
		words[7] = "Woodward";
		words[8] = "4real";
		words[9] = "30Something";
		String word = words[(int) (Math.random() * words.length)];
		return word;
	}
}