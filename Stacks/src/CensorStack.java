
public class CensorStack extends StringStack {
    
    @Override
    public void push(String item) {
        if(item.toLowerCase().equals("darn")==false) {
            super.push(item);
        }
    }
    
    

}
