
public class Tester {

    public static void main(String[] args) {
        Money money1 = new Money(120);
        Money money2 = new Money(302);
        Money money3 = money1.add(money2);
        System.out.println(money3);
        System.out.println(money1);
        System.out.println(money2);
        
        Money money4 = money1.computeMNSalesTax(money1);
        money1 = money1.add(money4);
        System.out.println(money4);
        System.out.println(money1);
    }

}
