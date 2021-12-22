import java.util.Scanner;

/**
 * Takes a name First Last, reformats it and prints out LAST, First
 * @author Aashish Bharath
 *
 */
public class NameReformat {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String[] namePieces;
		String userInput;
		String firstName;
		String lastName;
		
		System.out.print("Please enter name (First Last): ");
		userInput = keyboard.nextLine();
		//namePieces = ["John", "Doe"]
		namePieces = userInput.split(" ");
		
		firstName = namePieces[0];
		lastName = namePieces[1].toUpperCase();
		
		System.out.println(lastName + ", " + firstName);
		

	}

}
