import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Asks user to enter student na,es until finished,
 * and then enter "done". It then chooses a random student
 * 
 * @author Aashish Bharath
 *
 */
public class RadnomStudent {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random generator = new Random();
		ArrayList <String> students= new ArrayList<String>();
		
		System.out.println("Please enter in names below, once done enter done");
		
		while(true) {
			String currentName;
			System.out.print("Student name: ");
			currentName = keyboard.nextLine();
			if(currentName.equals("done")) {
				break;
			}else {
				students.add(currentName); 
			}
		}
		System.out.println("ArrayList: " + students);
		System.out.println("ArrayList has size " + students.size());
		int randomIndex = generator.nextInt(students.size());
		System.out.println("Random student is: " + students.get(randomIndex));
	}

}
