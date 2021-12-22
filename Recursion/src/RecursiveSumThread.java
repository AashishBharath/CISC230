
public class RecursiveSumThread extends Thread {
    public static final int THRESHOLD = 1000;
    private int[] arr;
    private int lo;
    private int hi;
    private int ans;
    
    public RecursiveSumThread(int[] a, int l, int h) {
        arr = a;
        lo = l;
        hi = h;
        ans = 0;
    }
    
    public int getAns() {
        return ans;
    }
    
    @Override
    public void run() {
        if(hi-lo < THRESHOLD) {
            for(int i = lo;i< hi;i++) {
                ans = ans + arr[i];
            }
        }else {
            RecursiveSumThread left = new RecursiveSumThread(arr,lo, (lo+hi)/2) ;
            RecursiveSumThread right = new RecursiveSumThread(arr, (lo+hi)/2, hi);
            left.start();
            right.run();
            try {
                left.join();
                //right.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            ans = left.ans + right.ans;
            
        }
        
       
    }
    
}
