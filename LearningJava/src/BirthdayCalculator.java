import java.util.Scanner;

/**
 * Program will ask user for their birthday in month/day/year
 * format, and then will print the date when the user will turn 65 years old
 * @author Aashish Bharath
 *
 */
public class BirthdayCalculator {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String[] datePieces;
		String userInput;
		int birthYear;
		int yearWhen65;
		
		System.out.print("Enter your birthday (month/day/year): ");
		userInput = keyboard.nextLine();
		
		//userInput = "10/25/1995"
		datePieces = userInput.split("/");
		// datePieces = ["10","25","1995"]
		birthYear = Integer.parseInt(datePieces[2]); 
		
		yearWhen65 = birthYear + 65;
		
		System.out.println("You will be 65 n " + yearWhen65);
		

	}

}
