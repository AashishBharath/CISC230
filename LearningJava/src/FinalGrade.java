import java.util.Scanner;

/**
 * Takes input from user (Lab average, exam average, and daily task average)
 * and then calculates their final grade
 * 
 * @author Aashish Bharath
 *
 */
public class FinalGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double finalGrade;
		double[] grades = new double[3];
		
		//User input for their averages
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Averages must be >= 0.0 and <= 100.0");
		System.out.print("Enter Lab Average: ");
		grades[0] = keyboard.nextDouble();
		System.out.print("Enter Exam Average: ");
		grades[1] = keyboard.nextDouble();
		System.out.print("Enter Daily Task Average: ");
		grades[2] = keyboard.nextDouble();
		
		//Calls finalPercent method to calcualate final percentage
		finalGrade = finalPercent(grades);
		System.out.println("Final Percent: "+ finalGrade + "%");
		
		//Checks what letter grade is received
		if(finalGrade >= 90.0) {
			System.out.println("Final Grade: A");
		}else if(finalGrade >= 80.0 && finalGrade < 90.0) {
			System.out.println("Final Grade: B");
		}else if(finalGrade >= 70.0 && finalGrade < 80.0) {
			System.out.println("Final Grade: C");
		}else if(finalGrade >= 60.0 && finalGrade < 70.0) {
			System.out.println("Final Grade: D");
		}else {
			System.out.println("Final Grade: F");
		}

	}
	/**
	 * @param Takes in array of final averages(Labs, Exams, Daily Tasks)
	 *
	 * @return double percentage based on weights of the class
	 */
	public static double finalPercent(double[] grades) {
		double percent;
		percent = (grades[0]*.6) + (grades[1]*.35) + (grades[2]*.05);
		return percent;
	}


}
