
/**
 * Decaf Coffee extends Coffee gaining all of its methods.
 * Calories and cost are the same for Coffee and Decaf Coffee, so only the toString() is Overridden
 * @author Aashish Bharath
 *
 */
public class DecafCoffee extends Coffee {
    /**
     * Decaf coffee shares the same information as coffee(cost, calories)
     * Since all information is the same as Coffee except the title, super.ToString() is called.
     * Example Output: Decaf Coffee+Sugar Syrup (S) - 65 calories
     * 
     *@return string representation of a Decaf Coffee, include title, size, and calories. 
     */
    @Override
    public String toString() {
        
        return "Decaf " + super.toString();
    }
        
    
    }


