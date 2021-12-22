
/**
 * OatMilk is a specific Addition object, thus OatMilk extends Addition.
 * 
 * @author Aashish Bharath
 *
 */
public class OatMilk extends Addition {

    /**
     * Creates a new Money object worth 100 cents($1.00) and returns it
     *@return oatMilkCost Money object that represents the cost of OatMilk
     */
    @Override
    public Money getCost() {
        Money oatMilkCost = new Money(100);
        
        return oatMilkCost;
    }

    /**
     *@return 30 the amount of calories an addition of OatMilk would be.
     */
    @Override
    public int getCalories() {
        return 30;
    }
    
    /**
     * This will be used in the beverage classes if Oat Milk is added to a Bevergae object.
     * an "+" is added because Oat Milk is an "addition" to a beverage.
     *@return String representation of an addition of Oat Milk
     */
    @Override
    public String toString() {
        return "+Oat Milk";
    }
    
    

}
