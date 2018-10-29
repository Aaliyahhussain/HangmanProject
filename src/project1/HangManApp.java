package project1;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangManApp {

	public static void main(String[] args) {
				Scanner scnr = new Scanner (System.in);
							
				String[] words = new String[8];

				words[0] = "Grand";
				words[1] = "Circus";
				words[2] = "Tim";
				words[3] = "David";
				words[4] = "Java";
				words[5] = "Roshambo";
				words[6] = "Coffee";
				words[7] = "Woodward";
				
				String word= words[(int) (Math.random() * words.length)];
				System.out.println("Would you like to play hang man?");
				String userSelection = scnr.next();
				
				if (userSelection.equalsIgnoreCase("yes")) {
					System.out.println(word + word.replaceAll(("[A-Z, a-z]"), " _ "));
					
					System.out.println("This word contains " + word.length());
				} else {

							
					
					System.out.println("Goodbye!");
				}
				
			}
}
