
public class SumThread extends Thread{
    private int[] arr;
    private int lo;
    private int hi;
    private int ans;
    
    
    public SumThread(int[] a, int l, int h) {
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
        //Compute sum, and get answer into ans
        System.out.println("At start of run");
        
        for(int i = lo;i<hi;i++) {
            ans = ans + arr[i];
        }
        System.out.println("At end of run");

    }
    
    

}
