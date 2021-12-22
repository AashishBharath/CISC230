import java.util.Random;

public class CoinFlipper2 extends Thread{
    
    private int numberOfFlips;
    private int numberOfHeads;
    private static Random generator = new Random();
    
    public CoinFlipper2(int flips) {
        numberOfFlips = flips;
        numberOfHeads = 0;
    }
    
    public int getHeads() {
        return numberOfHeads;
    }
    
    @Override
    public void run() {
        //Random generator = new Random();
        for(int i = 0;i<numberOfFlips;i++) {
            int current = generator.nextInt(2);
            if(current == 0) {
                numberOfHeads += 1;
            }
        }
    }

}
