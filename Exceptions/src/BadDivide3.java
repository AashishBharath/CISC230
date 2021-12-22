import java.util.Scanner;

/**
 * Ask user to enter two integers and divide them and display the result
 * @author aashi
 *
 */
public class BadDivide3 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String firstInput;
        String secondInput;
        int first = 0;
        int second = 0;
        boolean firstBad = false;
        boolean secondBad = false;
        
        System.out.print("Enter first integer: ");
        firstInput = keyboard.nextLine();
        
        System.out.print("Enter second integer: ");
        secondInput = keyboard.nextLine();
        
        
        try {
            first = Integer.parseInt(firstInput);
        } catch(NumberFormatException e) {
            firstBad = true;
        }  
        
        try {
          second = Integer.parseInt(secondInput);
        } catch(NumberFormatException e) {
            secondBad = true;
        }
        if(firstBad && secondBad) {
            System.out.println("Both inputs are not integers");
        }else if(firstBad) {
            System.out.println("First input is not an integer");          
        }else if(secondBad) {
            System.out.println("Second input is not an integer");
        }else {
           if(second!= 0) {
               System.out.println("Result: " + first/second);
           }else {
               System.out.println("Cannot divide by 0");
           }
        }
       

    }

}
