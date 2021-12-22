import java.util.Scanner;

/**
 * This class should ask the user to input 5 integers
 * and then compute the average of the 5 values.
 * 
 * @author Aashish Bharath
 *
 */
public class AverageValues {

	public static void main(String[] args) {
		double average;
		int[] values = new int[5];
		//int[] values = {1,2,3,4,5}; Assignning immediatly
		Scanner keyboard = new Scanner(System.in);
		for(int i = 0; i < values.length; i = i + 1) {
			System.out.print("Please enter a number: ");
			values[i] = keyboard.nextInt();
		}
		average = averageArray(values);
		System.out.println("Average is: " + average);
	

	}
	/**
	 * This method adds all the values in an array
	 * and then finds the average value
	 * 
	 * @param values(array) int values to be summed
	 * @return average int average value of values[]
	 */
	public static double averageArray(int[] values) {
		int total = 0;
		double average;
		for(int i = 0; i < values.length; i = i + 1) {
			total = total + values[i];
		}
		average = total/(double)values.length;
		return average;
	}

}
