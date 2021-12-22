//import java.util.Random;

public class RiggedDie extends Die {
    
    private int impossibleValue;
    
    public RiggedDie(int impossibleValue) {
        super(6);
        this.impossibleValue = impossibleValue;
    }
    
    @Override
    public void roll() {
        super.roll();
        while(super.getFaceValue() == impossibleValue) {
            super.roll();
        }
      
    }

}
