import java.util.ArrayList;

/**
 * Abstract class that serves as a super to any beverage. 
 *Implements the Buyable class, so it includes getCost();
 * @author Aashish Bharath
 *
 */
public abstract class Beverage implements Buyable {
    /**Constant for a beverage that is size small.*/
    public static final int SMALL = 0;
    /**Constant for a beverage that is size Large.*/
    public static final int LARGE = 2;
    /**
     * Arraylist of Addition objects which hold any add on objects.
     * Add ons include Oat Milk and Sugar Syrup.
     * Variable is protected so it can be used to calculate costs, and calories in any
     * class that extends Beverage. 
     */
    protected ArrayList<Addition> addOns;
    /**Size of the beverage, Small is represented with 0, and Large is represented with 2*/
    protected int size;
    
    /**
     * Initializes addOns as a new ArrayList of Additions objects.
     */
    public Beverage() {
  
        addOns = new ArrayList<Addition>();
        
    }
    
    /**
     *First abstract method of Beverage.
     *Must be used in classes that extend Beverage, and must return a Money Object that represents cost of item.
     */
    public abstract Money getCost();
    
    /**
     * Second abstract method of Beverage.
     * Must be used in classes that extend Beverage, and must return an int that represents total calories of item.
     * @return
     */
    public abstract int getCalories();
    
    
    
    /**Sets size to either a Small(0) or Large(2) beverage. 
     * @param size should either be a 0 or 2 
     */
    public void setSize(int size) {
        if(size == 0) {
            this.size = 0;
        }else {
        this.size = 2;
        }
    }
    
    /**Adds any Additon item to addOns.
     * @param item should be an Additon Object(Oat Milk or Sugar Syrup)
     */
    public void addToDrink(Addition item) {
        addOns.add(item);
    }
    
    
    

}
