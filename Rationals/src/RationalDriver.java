
public class RationalDriver {

    public static void main(String[] args) {
        Rational number = new Rational(2,5);
        Rational number2 = new Rational(2,3);
        Rational number3 = new Rational(2,5);
        Rational number4 = new Rational(4,10);
        
        System.out.println(number.equals(number2));
        System.out.println(number.equals(number3));
        System.out.println(number.equals(number4));
        
        Rational zero = new Rational(0,10);
        Rational anotherZero = new Rational(0,6);
        System.out.println(zero.equals(anotherZero));
        
        //Let's say we want to use gcd() 
        //x = 156, y = 94
        //Must create a rational object and then use gcd on it
        Rational fake = new Rational(999,888);
        //gcd does not need Rational object. 
        System.out.println(fake.gcd(156, 96));
        
        //Static methods are associated with class and not object
        System.out.println(Rational.gcd(156, 96));
        
        //Class variables
        System.out.println(number.add(Rational.ONE));
        
        //Static method Ex.)
        // Math.min(x,y);
        //Integer.parseInt
        
        Rational fiveEights = Rational.fromDivideString("5/8");
        System.out.println(fiveEights);
        
        Rational decimal = Rational.fromDecimalString("3.25");
        System.out.println(decimal);

        Rational wholeNumber = Rational.fromWholeNumberString("52");
        System.out.println(wholeNumber);
        
    }

}
