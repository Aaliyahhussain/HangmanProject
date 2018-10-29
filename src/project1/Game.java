package project1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

    public class Game {
    	String player = "";
        int turn = 3;
        List<String> word = new ArrayList<String>();
        boolean hangman = false;
        Scanner scan;
        Random random = new Random();

        String letters;     // For displaying letters
        String mask;        // For character Mask
 
        public Game(String[] HangMan, Scanner scanner){
        scan = scanner;
        
        int selectA = random.nextInt(((CharSequence) word).length());
        
        String hide = letters.replaceAll("\\S", "*"); //hides the words
       
       System.out.println("Random word selected: " + hide);
       System.out.println("This word contains " +letters.length()+ "letters");
       
       while (hangman == false) {
           System.out.println("Turns remaining: " + turn);
           System.out.println("Please choose a letter A-Z :");
           String ChosenLetter = scan.next();

           if (word.contains(ChosenLetter)) {
               System.out.println("Letter already chosen please choose another letter");
           } else {
               word.add(ChosenLetter);
           }

           if (letters.contains(ChosenLetter)) {
               char[] cLetters = letters.toCharArray();    //Load letters and hide to char array for editing
               char[] chide = hide.toCharArray();

               for(int i=0; i < chide.length; i++){
                   if(cLetters[i] == ChosenLetter.charAt(0)){
                       chide[i] = cLetters[i];
                   }
               }

               hide = new String(chide);   //Load new hide into String

               System.out.println("words letters are: " + word);
               System.out.println("Yes!" + hide);                      // Prints hide after Yes!

               turn--;
           } else {
               System.out.println("words letters are: " + word);
               System.out.println("No!" + hide);                               //Prints hide after No!
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

}
   