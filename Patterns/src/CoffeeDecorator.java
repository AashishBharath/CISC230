
public abstract class CoffeeDecorator implements Coffee{
    
    protected Coffee innerCoffee;
    
    public CoffeeDecorator(Coffee inner) {
        innerCoffee = inner;
    }
    
    public double getCost() {
        return innerCoffee.getCost();
    }
    
    public int getCalories() {
        return innerCoffee.getCalories();
    }
    
    public String getIngredients() {
        return innerCoffee.getIngredients();
    }

}
