import java.util.Arrays;

public class OrderRationals {

    public static void main(String[] args) {
        Rational[] numbers = new Rational[5];
        numbers[0] = new Rational(5,1);
        numbers[1] = new Rational(3,4);
        numbers[2] = new Rational(0,1);
        numbers[3] = new Rational(3,2);
        numbers[4] = new Rational(1,2);
        
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
  

    }
    

}
