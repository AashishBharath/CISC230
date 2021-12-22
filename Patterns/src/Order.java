import java.util.ArrayList;

public class Order {
    private ArrayList<Double> items;
    private DiscountStrategy discountStrategy;
    
    public Order() {
        items = new ArrayList<Double>();
        discountStrategy = new NoDiscount();
    }
    
    public void add(double item) {
        items.add(item);
    }
    
    public void setDiscount(DiscountStrategy newStrategy) {
        discountStrategy = newStrategy;
    }
    
    public double computeTotal() {
        double total = 0.0;
        for(int i = 0; i< items.size();i++) {
            total = total + items.get(i);
        }
        return discountStrategy.discount(total);
        
      
    }

}
