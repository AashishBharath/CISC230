import java.util.Random;

public class CoinFlipper extends Thread{
    
    private int numberOfCoins;
    private int numberOfHeads;
    
    public CoinFlipper(int coins) {
        numberOfCoins = coins;
        numberOfHeads = 0;
    }
    
    public int getHeads() {
        return numberOfHeads;
    }
    
    @Override
    public void run() {
        Random generator = new Random();
        for(int i = 0;i<numberOfCoins;i++) {
            int current = generator.nextInt(2);
            if(current == 0) {
                numberOfHeads += 1;
            }
        }
    }

}
