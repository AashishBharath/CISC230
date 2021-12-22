
public class StackDriver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringStack theStack = new StringStack();
            theStack.push("apple");
            System.out.println(theStack.pop());
            System.out.println(theStack.pop());
            
        CensorStack stack = new CensorStack();
        stack.push("hello");
        stack.push("darn");
        stack.push("DaRn");
        stack.push("words");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        
    }

}
