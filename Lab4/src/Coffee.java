
/**Coffee class extends Beverage.
 * Coffee is represented by its specific cost and calories amount depending on size and add ons. 
 * Override both abstract classes: getCost() and getCalories()
 * @author Aashish Bharath
 *
 */
public class Coffee extends Beverage {

    /**
     *Overrides the getCost() from Beverage and Buyable classes. 
     *If the size is 0(small), coffee is $1.50
     *If the size is 1(large), coffee is $2.50
     *@return coffeeCost  Money object which is a total amount coffeeCost including any add on cost.
     */
    @Override
    public Money getCost() {
        Money coffeeCost;
        if(super.size == 0) {
            coffeeCost = new Money(150);
        }else {
            coffeeCost = new Money(250);
        }
        if(super.addOns.size()>0) {
            for(int i = 0; i<super.addOns.size();i++) {
                coffeeCost = coffeeCost.add(super.addOns.get(i).getCost());
            }
        }
        
        return coffeeCost;
    }

    /**
     *If the size is 0(small), coffee is 5 calories
     *If the size is 1(large), coffee is 15 calories
     *@return the calories amount in int form
     */
    @Override
    public int getCalories() {
        if(super.size == 0) {
            return 5;
        }
        return 15;
    }
    
    /**
     * Prints out any addOns included with the Coffee using the Additi on objects' toString methods. 
     * Example output: Coffee+Sugar Syrup (S) - 65 calories
     *@return a string representation of a coffee object - include title, size, calories. 
     */
    @Override
    public String toString() {
        String coffee = "Coffee";
        int size = super.size;
        int totalCalories = getCalories();
        if(super.addOns.size()>0) {
            for(int i = 0; i<super.addOns.size();i++) {
                coffee = coffee + addOns.get(i);
                totalCalories = totalCalories + addOns.get(i).getCalories();
            }
            if(size == 0) {
                return coffee + " (S) - " + totalCalories + " calories";
            }else {
                return coffee + " (L) - " + totalCalories + " calories";
            }
        }else {
            if(size == 0) {
                return coffee + " (S) - " + totalCalories + " calories";
            }
            
        }
        return coffee + " (L) - " + totalCalories + " calories";
    }
    
     

}
