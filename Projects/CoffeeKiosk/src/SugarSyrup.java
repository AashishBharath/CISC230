/**
 * SugarSyrup is a specific Addition object, thus SugarSyrup extends Addition.
 * 
 * @author Aashish Bharath
 *
 */
public class SugarSyrup extends Addition {

    /**
     *Creates a new Money object worth 50 cents($0.500) and returns it
     *@return sugarSyrupCost Money object that represents the cost of Sugar Syrup
     */
    @Override
    public Money getCost() {
        Money sugarSyrupCost = new Money(50);
        
        return sugarSyrupCost;
    }

    /**
     *@return 60 the amount of calories an addition of SugarSyrup would be.
     */
    @Override
    public int getCalories() {
        return 60;
    }
    
    /**
     * This will be used in the beverage classes if Sugar Syrup is added to a Beverage object.
     * an "+" is added because Sugar Syrup is an "addition" to a beverage.
     *@return String representation of an addition of Sugar Syrup
     */
    @Override
    public String toString() {
        return "+Sugar Syrup";
    }
    

}
