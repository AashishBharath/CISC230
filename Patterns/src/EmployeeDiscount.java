
public class EmployeeDiscount implements DiscountStrategy{

    @Override
    public double discount(double price) {
        // TODO Auto-generated method stub
        return .8 * price;
    }

}
