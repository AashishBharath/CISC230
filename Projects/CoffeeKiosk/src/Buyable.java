
/**
 * Buyable is the completely abstract interface that serves as a outline for any Buyable object.
 * Any buyable object must include the getCost(); method 
 * 
 * @author Aashish Bharath
 */
public abstract interface Buyable {
    
    /**
     * Abstract method, getCost()
     * Must be used in accordance to individual Buyable objects, and must return a Money object.
     */
    public abstract Money getCost();

}
