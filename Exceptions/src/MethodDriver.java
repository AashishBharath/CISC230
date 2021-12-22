
public class MethodDriver {

    public static void main(String[] args) {

        System.out.println("About to call method 1...");
        try {
        method1(10);
        } catch(ArithmeticException e) {
            System.out.println("Caught in main");
        }
        System.out.println("Method 1 returned to main");

    }

    public static void method1(int x) {
        System.out.println("Calling method2 from method1");
        try {
        method2(x);
        } catch(ArithmeticException e) {
            System.out.println("Caught in method 1");
        }
        System.out.println("Method2 returned to method1");
    }

    public static void method2(int y) {
        int z;
        System.out.println("About to divide in method2");
        z = y/0;
        System.out.println("Done dividing in method2");


    }

}
