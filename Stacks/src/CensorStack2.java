
public class CensorStack2 {
    private StringStack theStack;
    
    public CensorStack2() {
        theStack = new StringStack();
    }
    
    public void push(String item) {
        if(item.toLowerCase().equals("darn")==false) {
            theStack.push(item);
        }
    }
    
    public String pop() {
        return theStack.pop();
    }
    
    }


