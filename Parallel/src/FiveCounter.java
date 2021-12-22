import java.util.concurrent.RecursiveAction;

public class FiveCounter extends RecursiveAction{
    public static final int THRESHOLD = 1000;
    private int[] arr;
    private int lo;
    private int hi;
    private int numberOfFives;
    
    public FiveCounter(int[] numArray, int low, int high) {
        arr = numArray;
        lo = low;
        hi = high;
        numberOfFives = 0;
    }
    
    public int getFives() {
        return numberOfFives;
    }

    @Override
    protected void compute() {
        if(hi-lo <= THRESHOLD) {
            for(int i = lo;i<hi;i++) {
                if(arr[i] == 5) {
                    numberOfFives = numberOfFives + 1;
                }
            }
        }else {
            FiveCounter left = new FiveCounter(arr, lo, (lo+hi)/2);
            FiveCounter right = new FiveCounter(arr, (lo+hi)/2, hi);
            
            left.fork();
            right.compute();
            left.join();
            
            numberOfFives = left.numberOfFives + right.numberOfFives;

        }
    }

}
