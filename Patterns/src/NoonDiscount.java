
public class NoonDiscount implements DiscountStrategy {

    @Override
    public double discount(double price) {
        // TODO Auto-generated method stub
        return .9 * price;
    }

}
