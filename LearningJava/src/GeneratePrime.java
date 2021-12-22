import java.util.Random;


/**
 * Generates a random prime number 1-1000 using
 * rejection sampling
 * @author Aashish Bharath
 *
 */
public class GeneratePrime {

	public static void main(String[] args) {
		Random generator = new Random();
		int candidate;
		
		candidate = generator.nextInt(1000);
		while(checkPrime(candidate) == false) {
			candidate = generator.nextInt(1000);
			
		}
		System.out.println("Prime number is " + candidate);

	}
	
	/**
	 * Checks if a number is prime or not
	 * 
	 * @param candidate that will be checked to see if it is prime
	 * @return true(it is prime) or false(it is not prime)
	 */
	public static boolean checkPrime(int candidate) {
		if(candidate < 2) {
			return false;
		}
		//only have to go to sqrt(candidate)
		for(int i = 2; i < Math.sqrt(candidate); i++) {
			if(candidate%i == 0) {
				//is not prime
				return false;
			}
		}
		//must be prime
		return true;
	}

}
