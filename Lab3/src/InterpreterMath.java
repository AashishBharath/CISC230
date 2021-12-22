 
/**
 * InterpreterMath extends Interpreter. If InterpreterMath is used mathematical operations commands may be called in addition to any
 * regular DishIt commands.
 * These additional commands include addition, multiplication, subtraction, and division.
 * @author Aashish Bharath
 *
 */
public class InterpreterMath extends Interpreter {
    
    
    /**
     * InterpreterMath uses the theStack, a protected FancyStack found in Interpreter.
     */
    public InterpreterMath() {
      
    }
    
   
   
    /**
     *@param operator String that could be new data to be added to theStack or an operator command. 
     * @return true if operator is added to theStack or operator is a valid operator, false if there is an error detected.
     * 
     * This eval() method overrides the eval() found in interpreter. If the operator is a valid math command, then this method 
     * computed the desired mathematical operation, otherwise super.eval() is called.
     *
     */
    @Override
    public boolean eval(String operator) {
        if(operator.equals("OP_ADD")) {
            if(theStack.size()<2) {
                System.out.println("Adding...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            add(operator);
            return true;
        }
        
        else if(operator.equals("OP_MULT")) {
            if(theStack.size()<2) {
                System.out.println("Multiplying...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            multiply(operator);
            return true;

        }
        
        else if(operator.equals("OP_SUB")) {
            if(theStack.size()<2) {
                System.out.println("Subtracting...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            subtract(operator);
            return true;

        }
        
        else if(operator.equals("OP_DIV")) {
            if(theStack.size()<2) {
                System.out.println("Dividing...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            divide(operator);
            return true;
        }
        else if(super.eval(operator)) {
            return true;
        }
        return true;
    }
    
    
    
    /**
     * @param operator String that is a valid operator command.
     * Method takes the top two strings off theStack, converts them to Integers, adds them together,
     * and pushes added value back onto theStack.
     * 
     * Uses push() and pop() methods found in StringStack.
     */
    private void add(String operator) {
        
        int firstValue;
        int secondValue;
        int addedValue;
  
        firstValue = Integer.parseInt(theStack.pop());
        secondValue = Integer.parseInt(theStack.pop());
    
        addedValue = firstValue + secondValue;
        
        theStack.push("" + secondValue);
        theStack.push("" + firstValue);
        theStack.push("" + addedValue);
        System.out.println("Doing addition...");
    }
    
    /**
     * @param operator String that is a valid operator command.
     * Method takes the top two strings off theStack, converts them to Integers, multiplies them,
     * and pushes multiplied value back onto theStack.
     * 
     * Uses push() and pop() methods found in StringStack.
     */
    private void multiply(String operator) {
        
        int firstValue;
        int secondValue;
        int multipliedValue;
        
        firstValue = Integer.parseInt(theStack.pop());
        secondValue = Integer.parseInt(theStack.pop());
        
        multipliedValue = firstValue * secondValue;
        
        theStack.push("" + secondValue);
        theStack.push("" + firstValue);
        theStack.push("" + multipliedValue);
        System.out.println("Doing multiplication...");
    }
    
    /**
     * @param operator String that is a valid operator command.
     * Method takes the top two strings off theStack, converts them to Integers, subtracts the second value from the top from the top value,
     * and pushes the value after subtraction back onto theStack.
     * 
     * Uses push() and pop() methods found in StringStack.
     */
    private void subtract(String operator) {
        int firstValue;
        int secondValue;
        int subtractedValue;
        
        firstValue = Integer.parseInt(theStack.pop());
        secondValue = Integer.parseInt(theStack.pop());
        
        subtractedValue = firstValue - secondValue;
        
        theStack.push("" + secondValue);
        theStack.push("" + firstValue);
        theStack.push("" + subtractedValue);
        System.out.println("Doing subtraction...");
    }
    
    /**
     * @param operator String that is a valid operator command.
     * Method takes the top two strings off theStack, converts them to Integers, divides the second value from the top from the top value ,
     * and pushes the value after division back onto theStack.
     * 
     * Uses push() and pop() methods found in StringStack.
     */
    private void divide(String operator) {
        int firstValue;
        int secondValue;
        int dividedValue;
        
        firstValue = Integer.parseInt(theStack.pop());
        secondValue = Integer.parseInt(theStack.pop());
        
        dividedValue = firstValue/secondValue ;
        
        theStack.push("" + secondValue);
        theStack.push("" + firstValue);
        theStack.push("" + dividedValue);
        System.out.println("Doing division...");
    }

}
