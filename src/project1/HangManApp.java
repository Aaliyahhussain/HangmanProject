package project1;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangManApp {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int turn = 8;
		boolean hangman = false;
		String letter;
		String words;
		String hide;

		String word = generateRandomWord();
		hide = word.replaceAll("[A-Za-z]", "_");

		System.out.println("Would you like to play hang man?");
		String userSelection = scnr.next();
		if (userSelection.equalsIgnoreCase("yes")) {
			System.out.println("Random word selected: " + hide);
			System.out.println("This word contains " + word.length() + "characters");
			{
			}
		} else {

			System.out.println("Goodbye!");
			System.exit(0);
		}

		while (hangman == false) {
			System.out.println("Turns remaining: " + turn);
			System.out.println("Please choose a letter A-Z :");
			String ChosenLetter = scnr.next();
			if (word.contains(ChosenLetter)) {
				System.out.println("You have chosen correctly please choose another letter");

			}
			if (word.contains(ChosenLetter)) {
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
			}

			else {
				System.out.println("WRONG!, Try again!" + hide); // Prints hide after No!
				turn--;
			}
			if (turn == 0) {
				hangman = true;
			}
			while (hangman == true) {
				System.out.println("You lost!");
				System.exit(0);
			}

		}

	}

	private static String generateRandomWord() {
		String[] words = new String[8];
		words[0] = "Grand";
		words[1] = "Circus";
		words[2] = "Tim";
		words[3] = "David";
		words[4] = "Java";
		words[5] = "Roshambo";
		words[6] = "Coffee";
		words[7] = "Woodward";
		String word = words[(int) (Math.random() * words.length)];
		return word;
	}
}