 import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class FivesDrivers {

    public static void main(String[] args) {
        long startTime;
        long endTime;
        int[] arr = new int[50000000];
        Random generator = new Random();
        for(int i = 0;i<arr.length;i++) {
            arr[i] = generator.nextInt(11);
        }
        
        startTime = System.currentTimeMillis();
        FiveCounter initial = new FiveCounter(arr, 0, arr.length);
        ForkJoinPool.commonPool().invoke(initial);
        endTime = System.currentTimeMillis();
        System.out.println("Fork join took: " + (endTime-startTime)/1000.0 + " s");
        System.out.println("Number of fives: " + initial.getFives());
    }

}
