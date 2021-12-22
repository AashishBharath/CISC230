import java.util.concurrent.RecursiveAction;

public class SumAction extends RecursiveAction {

    public static final int THRESHOLD = 1000;
    private int[] arr;
    private int lo;
    private int hi;
    private int ans;
    
    public SumAction(int[] a, int l, int h) {
        arr = a;
        lo = l;
        hi = h;
        ans = 0;
    }
    
    public int getAns() {
        return ans;
    }
    
    @Override
    public void compute() {
        if(hi-lo < THRESHOLD) {
            for(int i = lo;i< hi;i++) {
                ans = ans + arr[i];
            }
        }else {
            SumAction left = new SumAction(arr,lo, (lo+hi)/2) ;
            SumAction right = new SumAction(arr, (lo+hi)/2, hi);
            left.fork();
            right.compute();
           
            left.join();
            //right.join();
            
            
            ans = left.ans + right.ans;
            
        }
        
       
    }


}
