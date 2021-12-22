
public class WithSoy extends CoffeeDecorator{

    public WithSoy(Coffee inner) {
        super(inner);
    }
    
    public double getCost() {
        return super.getCost() + .75;
    }
    
    public int getCalories() {
        return super.getCalories() + 100;
    }
    
    public String getIngredients() {
        return super.getIngredients() + " + Soy Milk";
    }
    

}
