import java.util.Scanner;
/**
 * This class converts Fahrenheit tempertures to celsius.
 * 
 * Ask user to input a temperature and then converts that to celsius and then will
 * tell user how nice a day it is. 
 * 
 * @author Aashish Bharath
 *
 */

public class TemperatureConverter {

	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		double fahrenheit;
		fahrenheit = -20.0;
		
		while(fahrenheit<= 100.0) {
			double celsius;
			celsius = toCelsius(fahrenheit);
			System.out.println("* " + fahrenheit +"F is " +celsius+ "C");
			fahrenheit = fahrenheit + 10;
		}
		// ask user for temperature
		System.out.print("Please input a temperature: ");
		fahrenheit = keyboardInput.nextDouble();
		System.out.println("That temperature is " + toCelsius(fahrenheit)+ " C");
		if(fahrenheit <= 50.0){
			System.out.println("It will be too cold.");
			
		}else if(fahrenheit >= 85.0){
			System.out.println("It will be too hot.");
		}else {
			System.out.println("It will be perfect!");
		}
	}
	
	/**
	 * The method converts Fahrenheit to Celsius
	 * @param fahrenheit input temperature
	 * @return input temperature converted to celsius
	 */
	public static double toCelsius(double fahrenheit) {
		double celsius;
		celsius = (fahrenheit - 32) * 5.0/9.0;
		return celsius;
	}
	
	

}
