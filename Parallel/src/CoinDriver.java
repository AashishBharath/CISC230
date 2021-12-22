import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class CoinDriver {

    public static void main(String[] args) throws InterruptedException {
        Random generator = new Random();
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        int numberOfHeads = 0;
        int coins = 1000000000;
        for(int i = 0; i<=coins; i++) {
            int current = generator.nextInt(2);
            if(current == 0) {
                numberOfHeads += 1;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Sequntial took " + (endTime-startTime)/1000.0 + " s");
        System.out.println("Number of heads: " + numberOfHeads);
        
        //Thread
        startTime = System.currentTimeMillis();
        CoinFlipper2 flip1 = new CoinFlipper2(coins/2);
        CoinFlipper2 flip2 = new CoinFlipper2(coins - coins/2);
        
        flip1.start();
        flip2.run();
        
        flip1.join();
        //flip2.join();
        
        endTime = System.currentTimeMillis();
        System.out.println("Threads took " + (endTime-startTime)/1000.0 + " s");
        System.out.println("Number of heads: " + (flip1.getHeads() + flip2.getHeads()));
        
        
        
        startTime = System.currentTimeMillis();
        CoinAction initial = new CoinAction(coins);
        ForkJoinPool.commonPool().invoke(initial);
        endTime = System.currentTimeMillis();
        System.out.println("Fork join took: " + (endTime-startTime)/1000.0 + " s");
        System.out.println("Number of heads: " + initial.getHeads());

        
    }

}
