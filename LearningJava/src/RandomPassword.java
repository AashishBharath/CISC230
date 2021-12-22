import java.util.Random;
import java.util.Scanner;

/**
 * Class asks the user for a password length,
 * an then generates a random password of that length.
 * @author Aashish Bharath
 *
 */
public class RandomPassword {

	public static void main(String[] args) {
		Random generator = new Random();
		Scanner keyboard = new Scanner(System.in);
		int passwordLength;
		
		System.out.print("Type password length: ");
		passwordLength = keyboard.nextInt();
		
		
		for(int i = 1; i<=passwordLength; i++) {
			// generate random ASCII row number in the desired range, turn into a char. 
			// range:
			int asciiRow = generator.nextInt(127-33)+33;
			char currentChar = (char)asciiRow;
			System.out.print(currentChar);
			
		}

	}

}
