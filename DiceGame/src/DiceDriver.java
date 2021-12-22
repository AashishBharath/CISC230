
/**
 * This is the Driver for our Dice example.  It creates two 
 * dice, rolls them, and displays their face values.
 * 
 * @author Aashish Bharath
 *
 */
public class DiceDriver {

    public static void main(String[] args) {
        // We want two six-sided die objects
        RiggedDie die = new RiggedDie(4);
        die.roll();
        System.out.println(die);

    }

}
