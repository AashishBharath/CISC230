import java.util.Random;
import java.util.Scanner;

/**
 * This class asks for password length
 * and prints out a random password using only numbers and letters(upper and lowerecase).
 * 
 * @author Aashish Bharath
 *
 */
public class RandomPassword2 {

	public static void main(String[] args) {
		Random generator = new Random();
		Scanner keyboard = new Scanner(System.in);
		int passwordLength;
		
		System.out.print("Type password length: ");
		passwordLength = keyboard.nextInt();
		
		
		for(int i = 1; i<=passwordLength; i++) {
			// generate random ASCII row number in the desired range, turn into a char. 
			// range:
			int asciiRow;
			int chooseNumOrLetter = generator.nextInt(3);
			if(chooseNumOrLetter == 0) {
				asciiRow = generator.nextInt(58-48)+48;
			}else if(chooseNumOrLetter == 1) {
				asciiRow = generator.nextInt(91-65)+65;
			}else {
				asciiRow = generator.nextInt(123-97)+97;
			}
			
			char currentChar = (char)asciiRow;
			System.out.print(currentChar);
			
		}

	}
}
