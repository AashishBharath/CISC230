
/**
 * Interpreter has two methods; eval and evalMultiple. These take in operator commands and manipulate a stack (theStack)
 * based on the input commands.
 * 
 * @author Aashish Bharath  
 *
 */
public class Interpreter {
    
    /**
     * theStack is a FancyStack from the FancyStack class.
     * Holds data inputed by the user.It can only store data. It will not store valid operator commands.
     * theStack is a protected variable, so it can be used in InterpreterMath. 
     */
    protected FancyStack theStack;
    
    
    /**
     * Initializes theStack as a new FancyStack.
     */
    public Interpreter() {
        theStack = new FancyStack();
    }
    
    /**
     * @param operators Array of strings, each item of operators could either be new data added to theStack or an operator command.
     * @return true if a new data point is added to theStack or operator is a valid operator, false if there is any error detected.
     * 
     * evalMultiple() uses eval() each string in operators individually is evaluated by eval(). 
     * If something is added to the stack or there is a valid operator, then true is returned. All of the items must be true for true to be returned
     * Only when there is an error detected will there be a return value of false. As soon as an error is detected, false is returned. 
     */
    public boolean evalMultiple(String [] operators) {
        boolean checkOperators = false;
        for(int i = 0; i< operators.length;i++) {
            
            operators[i] = operators[i].trim();
            checkOperators = eval(operators[i]);
            if(checkOperators == false) {
                checkOperators = false; 
                break;
            }
        }
        
        return checkOperators;
    }
    
     
    /**
     * @param operator individual String that could be new data added to theStack or an operator command. 
     * @return true if operator is added to theStack or operator is a valid operator, false if there is any error detected.
     * 
     *  Uses a series of private helper methods to manipulate theStack if operator is a valid operator command.
     *  If operator is not a command then it will be added to theStack. 
     *  eval() will only return false when there is an error. An error would occur when operator is a valid command, but
     *  it cannot be invoked on theStack.
     *  
     *  An example of an error: OP_EQUAL called when the size of theStack is less than 2.
     */
    public boolean eval(String operator) {

        if(operator.equals("OP_DUP")) {
            if(theStack.isEmpty()) {
                System.out.println("Duplicating...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            duplicate(operator);
            return true;
        }
        
        //DOES WORK
        else if(operator.equals("OP_REVERSE")) {
            
            if(theStack.isEmpty()) {
                System.out.println("Reversing...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            reverse(operator);
            return true;
        }
        

        else if(operator.equals("OP_CONCAT")) {
            if(theStack.size()<2) {
                System.out.println("Concatinating...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            concatenate(operator);
            return true;
        }
        
        else if(operator.equals("OP_EQUAL")) {
            if(theStack.size()<2) {
                System.out.println("Checking Equality...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            String firstWord;
            String secondWord;
            
            secondWord = theStack.pop();
            firstWord = theStack.pop();
            theStack.push(firstWord);
            theStack.push(secondWord);
            if(firstWord.equals(secondWord)) {
                theStack.push("true");
            }else {
                theStack.push("false");
            }
            System.out.println("Checking Equality...");
            return true;
        }


        else if(operator.equals("OP_LOWER")) {
            if(theStack.isEmpty()) {
                System.out.println("Lowering...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            
            toLowerCase(operator);
            return true;
        }


        else if(operator.equals("OP_UPPER")) {
            if(theStack.isEmpty()) {
                System.out.println("Uppering...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            toUpperCase(operator);
            return true;
        }

        else if(operator.equals("OP_DROP")) {
            if(theStack.isEmpty()) {
                System.out.println("Dropping...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            drop(operator);
            return true;
        }

        else if(operator.equals("OP_NIP")) {
            if(theStack.isEmpty()) {
                System.out.println("Nipping...");
                System.out.println("Error");
                System.out.println("Goodbye!");
                return false;
            }
            nip(operator);
            return true;
        }

        else if (operator.equals("OP_DEPTH")) {
            depth(operator);
            return true;
        }
        
        else if (operator.equals("OP_FINISH")) {
            finish(operator);
            return true;
        }
        else {
            System.out.println("Adding data to the stack...");
            theStack.push(operator);
        }
        
       
       return true; 
    }
    
    
    
    
    
    /**
     * @param operator String that is a valid operator command.
     * 
     * Method will take in a string and duplicate it making sure to push original and duplicate string onto the stack. 
     * Uses push() and pop() methods found in StringStack to duplicate the top item in theStack. 
     */
    private void duplicate(String operator) {
        String temporaryHolder;
        temporaryHolder = theStack.pop();
        theStack.push(temporaryHolder);
        theStack.push(temporaryHolder);
        System.out.println("Duplicating...");
    }
    
    
    
    /**
     * @param operator String that is a valid operator command.
     * 
     * Method concatenates the top two strings in theStack, and only pushes back the concatenated string .
     * Utilizes push() and pop() methods found in StringStack.  
     * 
     */
    private void concatenate(String operator) {
        String firstWord;
        String secondWord;
        
        secondWord = theStack.pop();
        firstWord = theStack.pop();
        
        theStack.push(firstWord + secondWord);
        System.out.println("Concatinating...");
    }
    
    /**
     * @param operator String that is a valid operator command.
     * 
     * Method takes the top string off the top of theStack and
     * reverses it. Only pushes back reversed string onto theStack.
     * Utilizes push() and pop() methods found in StringStack. 
     * 
     * 
     */
    private void reverse(String operator) {
        String temporaryHolder;
        String reversedWord = "";
        
        temporaryHolder = theStack.pop();
        char[] wordArray = temporaryHolder.toCharArray();
        for(int i = wordArray.length-1; i>=0; i--) {
            reversedWord = reversedWord + wordArray[i];
        }
        theStack.push(reversedWord);
        System.out.println("Reversing...");
    }
    
    
    
    /**
     * @param operator String that is a valid operator command.
     * Takes top string of theStack and converts the whole string to lower case.
     * Utilizes push() and pop() methods found in StringStack. 
     */
    private void toLowerCase(String operator) {
        String temporaryHolder;
        temporaryHolder = theStack.pop().toLowerCase();
        theStack.push(temporaryHolder);
        System.out.println("Lowering...");
        
    }
    
    
    
    /**
     * @param operator String that is a valid operator command.
     * Takes top string of theStack and converts the whole string to upper case.
     * Utilizes push() and pop() methods found in StringStack. 
     */
    private void toUpperCase(String operator) {
        String temporaryHolder;
        temporaryHolder = theStack.pop().toUpperCase();
        theStack.push(temporaryHolder);
        System.out.println("Uppering...");
        
    }
    
    /**
     * @param operator String that is a valid operator command.
     * Deletes second closest string to the top in theStack.
     * Utilizes push() and pop() methods found in StringStack. 
     */
    private void nip(String operator) {
        String firstInStack;
        String secondInStack;
        
        firstInStack = theStack.pop();
        secondInStack = theStack.pop();
        
        theStack.push(firstInStack);
        System.out.println("Nipping...");
        
    }
    
    /**
     * @param operator String that is a valid operator command.
     * Deletes top item in theStack.
     * Utilizes push() method found in StringStack.
     */
    private void drop(String operator) {
        theStack.pop();
        System.out.println("Dropping...");
        
    }
    
    /**
     * @param operator String that is a valid operator command.
     * Pushes onto theStack the size of theStack.
     * Utilizes push() method found in StringStack, and size() method found in FancyStack.
     */
    private void depth(String operator) {
        theStack.push("" + theStack.size());
        System.out.println("Calculating Stack Depth...");
        
    }
    
    /**
     * @param operator String that is a valid operator command.
     * Prints out the top item in theStack, and then clears theStack.
     * Utilizes pop() and clear() methods found in StringStack.
     */
    private void finish(String operator) {
        System.out.println("Final Answer: " + theStack.pop());
        theStack.clear();
        
    }

}
