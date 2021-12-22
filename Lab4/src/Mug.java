
/**
 * The Mug class implements Buyable.
 * Since it is a "Buyable" object, Mug must have a overridden getCost() method
 * The mug is represented as a "Classy Mug"
 * @author Aashish Bharath
 *
 */
public class Mug implements Buyable {

    /**
     * Creates a new Money object with the money value of the mug($10.00) and return the new money object.
     * 
     *@return mugCost Money object that has value of 1000 cents or $10.00
     */
    @Override
    public Money getCost() {
        Money mugCost = new Money(1000);
        return mugCost;
    }
    
    /**
     *In the shopping cart a mug is represented as a "Classy Mug"
     */
    public String toString() {
        return "Classy Mug: ";
    }

}
