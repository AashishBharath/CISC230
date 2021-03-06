import java.util.concurrent.ForkJoinPool;

public class PrimeDriver {

    public static void main(String[] args) {
        int[] numbers = new int[50000000];
        for(int i = 0; i<numbers.length;i++) {
            numbers[i] = i+1;
        }
        
        PrimeCounter initial = new PrimeCounter(numbers, 0, numbers.length);
        ForkJoinPool.commonPool().invoke(initial);
        System.out.println("The number of primes between 1 and 50,000,000 is " + initial.getAnswer());
    }

}
