import java.util.Random;

public class Coin {
    
    private int faceValue;
    
    public Coin() {
        faceValue = 1;
    }
    
    public void flip() {
        Random generator = new Random();
        faceValue = generator.nextInt(2);
    }
    
    public int getFaceValue() {
        return faceValue;
    }
    
    public String toString() {
        if(faceValue == 1) {
            return "H";
        }else {
            return "T";
        }
    }

}
