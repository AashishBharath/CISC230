import java.util.Random;

/**
 * Generates a random number between 1000 and 2000
 * Only returns the number if it is a multiple of 3
 * 
 * @author Aashish Bharath
 *
 */
public class GenerateMultiples {

	public static void main(String[] args) {
		int randomInteger;
		
		randomInteger = randomNumber(1000, 2000);
		
		while(checkMultiple(randomInteger) == false) {
			randomInteger = randomNumber(1000, 2000);
		}
		System.out.println("Number is: " + randomInteger);

	}
	/**
	 * @param minimum lower bound of range(1000)
	 * @param maximum upper bound of range(2000)
	 * @return a random number between 1000 and 2000
	 */
	public static int randomNumber(int minimum, int maximum) {
		Random generator = new Random();
		
		int randomInteger;
		randomInteger = generator.nextInt(maximum - minimum) + minimum;
		
		return randomInteger;
	
	}
	/**
	 * @param randomInteger is checked to see if it is a multiple of 3
	 * @return true if it is a multiple of 3, false otherwise.
	 */
	public static boolean checkMultiple(int randomInteger) {
		if (randomInteger % 3 == 0) {
			return true;
		}
		return false;
	}

}
