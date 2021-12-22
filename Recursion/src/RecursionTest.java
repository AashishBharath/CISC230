
public class RecursionTest {

    public static void main(String[] args) {
        System.out.println("5! is "+ factorial(5));
        
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        
        System.out.println("Sum is " +sum(arr, 0, 10));
    }
    
    public static int factorial(int n) {
        if(n==1) {
            return 1;
        }
        return n*factorial(n-1);
    }
    
    public static int sum(int[] arr, int lo, int hi) {
        if(lo>=hi) {
            return 0;
        }else if(hi-lo == 1) {
            return arr[lo];
        }
        return sum(arr, lo, (lo+hi)/2) + sum(arr,(lo+hi)/2, hi);
    }

}
 