
public class SeniorDiscount implements DiscountStrategy {

    @Override
    public double discount(double price) {
        return .8 * price;
    }

}
