import java.util.Random;

/**
 * Die Class. Series of methods to hold the faceValue of Die object and manipulate it.
 * Used in TenziGame Class. 
 * @author Aashish Bharath
 *
 */
public class Die {

    /**
     * Stores Face Value of Die Object
     */
    private int faceValue;



    /**
     * Initializes faceValue to 1
     */
    public Die() {
        faceValue = 1;
    }

    /**
     * "Rolls" Object
     * Generates Random faceValue for Die object
     */
    public void roll() {
        Random generator = new Random();
        faceValue = generator.nextInt(6)+1;
    }


    /**
     * @return Face Value of die object
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * @param other Die Object
     * @return true if this(Die object) has same faceValue as other(Die Object), false otherwise
     */
    public boolean compareTo(Die other) {
        if(this.faceValue == other.faceValue) {
            return true;
        }
        return false;
    }


    /**
     * Returns string form of Die object.
     * Ex. faceValue = 3 die.toString() --> "* * *"
     */
    public String toString() {
        String visualValue = "";
        for(int i = 0; i < faceValue; i++) {
            visualValue = visualValue + "* ";
        }
        return visualValue;
    }

}
