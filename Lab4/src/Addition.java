
/**
 * Addition is purely abstract class that serves as a template for any add ons to beverages.
 * 
 * @author Aashish
 *
 */
public abstract class Addition {
    
    /**
     * @return a Money object that represents the cost of the additonal item.
     */
    public abstract Money getCost();
    
    /**
     * @return an int that represents the calories amount of additional item.
     */
    public abstract int getCalories();

}
