import java.util.ArrayList;

/**
 * FancyStack extend StringStack.
 * 
 * FancyStack has methods like isEmpty(), clear(), and size(). All of which give information or manipulate the FancyStack.
 * @author Aashish Bharath
 *
 */
public class FancyStack extends StringStack {
    
    
    /**
     * isEmpty() checks if the top value in the stack is equal to null.
     * @return true if top value is null(stack is empty), false otherwise. 
     * 
     * Uses pop() method found in StringStack
     */
    public boolean isEmpty() {
        String temporaryHolder = super.pop();
        if(temporaryHolder == null) {
            return true;
        }else {
            super.push(temporaryHolder);
            return false;
        }
    }
    
    /**
     * This method clears the stack completley.
     * 
     * Utilizes a while loop and pop() method found in StringStack to pop items
     * in the stack until the only value in the stack is null.
     * 
     */
    public void clear() {
       while(super.pop()!= null) {
           super.pop();
       }
    }
    
    /**
     * @return the size of the stack, or the number of items in the stack.
     * 
     * Utlizes a while loop and pop() method found in StringStack to count 
     * the number of values while being popped off. Each popped value is stored in 
     * an ArrayList.
     * 
     * Once the stack is counted, the push() method found in StringStack is used to 
     * push values back onto the stack. 
     */
    public int size() {
        int sizeOfStack = 0;
        ArrayList<String> temporaryList = new ArrayList<String>();
        String temporaryHolder;
     
        temporaryHolder = super.pop();
        temporaryList.add(temporaryHolder);
        
        
        while(temporaryHolder!=null) {
            temporaryHolder = super.pop();
            sizeOfStack = sizeOfStack + 1;
            if(temporaryHolder == null) {
                break;
            }
            temporaryList.add(temporaryHolder);
            
        //Adds popped items back into super list
        }
        for(int i = sizeOfStack-1; i>=0; i--  ) {
            super.push(temporaryList.get(i));
        }
        
        return sizeOfStack;
    }
    

}
