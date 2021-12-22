import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class RecursiveThreadDriver {

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        Random generator = new Random();
        int len = arr.length;

        System.out.println("Filling array...");
        // fill array with random 0-4
        for (int i = 0; i < len; i++) {
            arr[i] = generator.nextInt(5);
        }
     
        System.out.println("Starting sequential...");
        int total = 0;
        for (int i = 0; i < len; i++) {
            total = total + arr[i];
        }
        System.out.println("Correct sum is "+total);

        
        //RecursiveSumThread summer = new RecursiveSumThread(arr, 0, len);
        //summer.run();
        SumAction initial = new SumAction(arr, 0, len);
        ForkJoinPool.commonPool().invoke(initial);
        
        System.out.println("Sum is " + initial.getAns());
        
    }

}
