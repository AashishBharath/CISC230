public class WithSugar extends CoffeeDecorator{

    public WithSugar(Coffee inner) {
        super(inner);
    }
    
    public double getCost() {
        return super.getCost() + .50;
    }
    
    public int getCalories() {
        return super.getCalories() + 50;
    }
    
    public String getIngredients() {
        return super.getIngredients() + " + Sugar Syrup";
    }
    

}