import java.util.Scanner;

/**
 * Ask user to enter two integers and divide them and display the result
 * @author aashi
 *
 */
public class BadDivide2 {

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
            
            try {
                
            
            second = Integer.parseInt(secondInput);
            try {
            System.out.println("Result: " + first/second);
            } catch(ArithmeticException e) {
                System.out.println("Cannot divide by 0");
                
            }
            }catch(NumberFormatException e){
                System.out.println("Second input must be an integer ");
                
            }
        } catch(NumberFormatException e) {
            System.out.println("First input must be an integer");
            
        } 

    }

}
