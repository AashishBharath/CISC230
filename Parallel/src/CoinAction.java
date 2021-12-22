import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class CoinAction extends RecursiveAction {
    public static final int THRESHOLD = 1000;
    private int numFlips;
    private int numHeads;
    
    public CoinAction(int flips) {
        numFlips = flips;
        numHeads = 0;
    }
    
    public int getHeads() {
        return numHeads;
    }
    

    @Override
    protected void compute() {
        if(numFlips <= THRESHOLD) {
            Random generator = new Random();
            for(int i = 1;i<numFlips;i++) {
                if(generator.nextInt(2) == 1) {
                    numHeads += 1;
                }
            }
        }else {
            CoinAction left = new CoinAction(numFlips/2);
            CoinAction right = new CoinAction(numFlips - numFlips/2);
            left.fork();
            right.compute();
            
            left.join();
            
            numHeads = left.getHeads() + right.getHeads();
        }
    }

}
