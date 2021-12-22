
public class CoffeeDriver {

    public static void main(String[] args) {
        Coffee myCoffee = new BasicCoffee();
        
        System.out.println("Current Coffee: " + myCoffee.getIngredients() + " " + myCoffee.getCost() + " " + myCoffee.getCalories());
        
        myCoffee = new WithSoy(myCoffee);
        
        System.out.println("Current Coffee: " + myCoffee.getIngredients() + " " + myCoffee.getCost() + " " + myCoffee.getCalories());

        myCoffee = new WithSugar(myCoffee);
        
        System.out.println("Current Coffee: " + myCoffee.getIngredients() + " " + myCoffee.getCost() + " " + myCoffee.getCalories());


    }

}
