/**Tea class extends Beverage.
 * Tea is represented by its specific cost and calories amount depending on size and add ons. 
 * Override both abstract classes: getCost() and getCalories()
 * @author Aashish Bharath
 *
 */
public class Tea extends Beverage {

    /**
     *Overrides the getCost() from Beverage and Buyable classes. 
     *If the size is 0(small), Tea is $1.50
     *If the size is 1(large), Tea is $1.50
     *@return teaCost  Money object which is a total amount teaCost including any add on cost.
     */
    @Override
    public Money getCost() {
        
        Money teaCost = new Money(150);
        if(super.addOns.size()>0) {
            for(int i = 0; i<super.addOns.size();i++) {
                teaCost = teaCost.add(super.addOns.get(i).getCost());
            }
        }
        
        return teaCost;
    }

    /**
     *If the size is 0(small), tea is 5 calories
     *If the size is 1(large), tea is 5 calories
     *@return the calories amount in int form
     */
    @Override
    public int getCalories() {
        return 5;
    }
    
    /**
     * Prints out any addOns included with the Tea using the Addition objects' toString methods. 
     * Example output: Tea+Oat Milk+Sugar Syrup (S) - 95 calories 
     *@return a string representation of a Tea object - include title, size, calories. 
     */
    @Override
    public String toString() {
        String tea = "Tea";
        int size = super.size;
        int totalCalories = getCalories();
        if(super.addOns.size()>0) {
            for(int i = 0; i<super.addOns.size();i++) {
                tea = tea + addOns.get(i);
                totalCalories = totalCalories + addOns.get(i).getCalories();
            }
            if(size == 0) {
                return tea + " (S) - " + totalCalories + " calories";
            }else {
                return tea + " (L) - " + totalCalories + " calories";
            }
        }else {
            if(size == 0) {
                return tea + " (S) - " + totalCalories + " calories";
            }
            
        }
        return tea + " (L) - " + totalCalories + " calories";
    }
    
    
    
    
    
   }
    
    
   


