import java.util.ArrayList;

public class StringStack {
    
    private ArrayList<String> items;
    
    
    public StringStack() {
        items = new ArrayList<String>();
    }
    
    
    public void push(String item) {
        items.add(item);
    }
    public String pop() {
        if(items.size()<1) {
            return null;
        }
        String poppedItem = items.get(items.size()-1);
        items.remove(items.size()-1);
        return poppedItem;
    }

}
