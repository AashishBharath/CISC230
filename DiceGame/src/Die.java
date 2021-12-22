import java.util.Random;

/**
 * This class is used to build Die objects of a specified number of sides 
 * that can be randomly rolled.
 * 
 * @author Aashish Bharath
 *
 */
public class Die {
    
    // instance variables (internal state)
    /** How many sides the Die has. */
    private int numberOfSides;
    
    /**
     * The current face value of the Die.
     */
    private int faceValue;
    
    
    // constructors
    
    /** 
     * This constructor builds a Die object with the input number of sides 
     * and sets the initial face value to 1.
     * 
     * @param sides The number of sides the Die should have.
     */
    public Die(int sides) {
        // job: put meaningful values into all instance variables
        numberOfSides = sides;
        faceValue = 1;
        
    }
    
    
    // methods
    
    /**
     * This method returns the current face value of the die.
     * 
     * @return The current face value of the Die object.
     */
    public int getFaceValue() {
        return faceValue;
    }
    
    
    
    /**
     * This method rolls the current Die, resulting 
     * in the face value being a random value from 
     * 1 to the number of sides.
     */
    public void roll() {
        Random generator = new Random();
        faceValue = generator.nextInt(numberOfSides)+1;
        
    }
    
    public String toString() {
        return "" + faceValue;
    }

}
