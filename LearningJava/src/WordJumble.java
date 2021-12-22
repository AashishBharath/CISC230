import java.util.Random;
import java.util.Scanner;

/**
 * Word jumble game that shows user that shows user
 * a jumbled word and allows them to guess the word.
 * 
 * @author aashish bharath
 *
 */
public class WordJumble {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String [] candidates = {"tiger","lion","giraffe","horse","lemur"};
		String correctWord = chooseRandomItem(candidates);
		String jumbledWord;
		String guess;
		
		jumbledWord = jumbleString(correctWord);
		
		//jumbledWord = "geirt";
		
		System.out.println("The jumbled word is "+ jumbledWord);
		System.out.print("Guess: ");
		guess = keyboard.nextLine();
		
		if(guess.toLowerCase().equals(correctWord)) {
			System.out.println("Correct!");
		}else {
			System.out.println("Incorrect");
		}

	}
	public static String jumbleString(String original) {
		char[] originalArray = original.toCharArray();
		shuffleCharArray(originalArray);
		
		return new String(originalArray);	 
		
	}
	
	public static void shuffleCharArray(char[] wordAsArray) {
		// ['h','e','l','l','o']
		Random generator = new Random();
		for(int i = 0; i < wordAsArray.length; i++) {
			int randomIndex;
			randomIndex = generator.nextInt(wordAsArray.length - i) + i;
			char temporary;
			temporary = wordAsArray[i];
			wordAsArray[i] = wordAsArray[randomIndex];
			wordAsArray[randomIndex] = temporary;
			
		}
	}
	public static String chooseRandomItem(String [] candidates) {
		Random generator = new Random();
		int candidateIndex = generator.nextInt(candidates.length);
		
		return candidates[candidateIndex];
	}
		 
}

