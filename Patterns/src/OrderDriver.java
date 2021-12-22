
public class OrderDriver {

    public static void main(String[] args) {
        Order bigOrder = new Order();
        bigOrder.add(7.50);
        bigOrder.add(35.00);
        bigOrder.add(5.00);
        
        System.out.println("Total with no discount: "+bigOrder.computeTotal());
        bigOrder.setDiscount(new NoonDiscount());
        System.out.println("Total with noon discount: "+bigOrder.computeTotal());
        bigOrder.setDiscount(new EmployeeDiscount());
        System.out.println("Total with employee discount: "+bigOrder.computeTotal());
        bigOrder.setDiscount(new SeniorDiscount());
        System.out.println("Total with senior discount: "+bigOrder.computeTotal());
        bigOrder.setDiscount(new NoDiscount());
        System.out.println("Back to no discount: "+bigOrder.computeTotal());
    }

}
