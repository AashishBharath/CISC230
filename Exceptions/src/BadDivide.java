import java.util.Scanner;

/**
 * Ask user to enter two integers and divide them and display the result
 * @author aashi
 *
 */
public class BadDivide {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String firstInput;
        String secondInput;
        int first;
        int second;
        
        System.out.print("Enter first integer: ");
        firstInput = keyboard.nextLine();
        
        System.out.print("Enter second integer: ");
        secondInput = keyboard.nextLine();
        
        try {
            first = Integer.parseInt(firstInput);
            second = Integer.parseInt(secondInput);
            
             
            System.out.println("Result: " + first/second);
        } catch(NumberFormatException e) {
            System.out.println("There was an error");
        } catch(ArithmeticException e) {
            System.out.println("Cannot divide by 0");
        }

    }

}
