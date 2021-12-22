import java.util.ArrayList;
/**
 * 
 * ShoopingCart is an object used to display everything in the users "cart".
 * It also calculates total cost of all the chosen products at any given time.
 * Included in the calculation of a user's total cost is MN sales tax. 
 * @author Aashish Bharath
 *
 */
public class ShoppingCart {
    /**
     * Private instance variable: items
     * Holds any "Buyable" item.
     * Buyables include Coffee, Decaf coffee, Tea, Beverage add-ons(Oat Milk, and Sugar Syrup), and a Fancy Mug.
     */
    private ArrayList<Buyable> items;
    
    /**
     * Initializes items as a new ArrayList 
     */
    public ShoppingCart() {
        items = new ArrayList<Buyable>();
        
    }
    
    /**
     * Adds item to the ArrayList, items. 
     * items is the "Shopping Cart" object.
     * items keeps track of all Buyable items that are added
     * to the "Shopping Cart".
     * @param item any "Buyable" item can be used as input. 
     */
    public void addItem(Buyable item) {
        items.add(item);
    }
    
    /**
     * This method adds up all the costs of the items in the ArrayList, items. 
     * This is where the MN tax is also computed, and added on to totalCost. 
     * @return totalCost Money object that is the total cost of all items in "Shopping cart" including taxes. 
     */
    public Money getTotal() {
        Money totalCost = new Money(0);
        for(int i = 0; i<items.size(); i++) {
            totalCost = totalCost.add(items.get(i).getCost());
        }
        Money totalCostTax = Money.computeMNSalesTax(totalCost);
        totalCost = totalCost.add(totalCostTax);
        return totalCost;
    }
    
    /**
     *Returns a String of the "Shopping Cart" as a numbered list.
     *Example output:
     *1.) Classy Mug: : $10.00
     *2.) Coffee+Oat Milk+Sugar Syrup (L) - 105 calories: $4.00
     *Total: $14.96
     */
    @Override
    public String toString() {
        String shoppingCart = "";
        if(items.size()==0) {
            return "Cart is empty";
        } 
        else {
            for(int i = 0; i< items.size();i++) {
                int listNumber = i+1;
                shoppingCart = shoppingCart + listNumber + ".) " + items.get(i).toString() +": " + items.get(i).getCost() + "\n";
            }
        }
        shoppingCart = shoppingCart + "Total: " + getTotal();
        return shoppingCart;
    }
    

}
