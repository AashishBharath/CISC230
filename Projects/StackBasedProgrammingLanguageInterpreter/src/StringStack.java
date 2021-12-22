
import java.util.ArrayList;

/**
 * StringStack creates a "stack".
 * A stack is an ArrayList in which items can only be accessed from the last value down to the first.
 * A stack follows "Last in First Out" and "First in Last Out".
 * @author Aashish Bharath
 * 
 *
 */
public class StringStack {
    
    /**
     * Items is an ArrayList of strings.
     * Represents a stack. 
     */
    private ArrayList<String> items;
    
    
    /**
     * Constructor initializes items as a new ArrayList of Strings. 
     */
    public StringStack() {
        items = new ArrayList<String>();
    }
    
    
    /**
     * @param item String that will be "pushed" onto the "top" of items.
     * Uses add() method from the ArrayList class to add item.
     */
    public void push(String item) {
        items.add(item);
    }
    
    /**
     * @return poppedItem the last/top item in the ArrayList, null if ArrayList is empty.
     * This method first checks if items is empty or not.
     * If not, the last item of the ArrayList removed from items and returned. 
     * 
     * 
     */
    public String pop() {
        if(items.size()<1) {
            return null;
        }
        String poppedItem = items.get(items.size()-1);
        items.remove(items.size()-1);
        return poppedItem;
    }
    

}
