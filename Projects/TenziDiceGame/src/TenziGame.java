import java.util.ArrayList;

/**
 * Holds all user data for the Tenzi Game.
 * Uses Die class.
 * Used by TenziDriver. 
 * @author Aashish Bharath
 *
 */
public class TenziGame {

    /**
     * Number of turns a player has used.
     */
    private int turns;
    /**
     * The current time when the player starts a new game.
     */
    private long startTime;
    /**
     * The current time when a player ends a game.
     */
    private long endTime;
    /**
     * An array list of 10 Die objects. (0-9)
     */
    private ArrayList<Die> theDice;


    /**
     * Initializes each instance variable. 
     * theDice is populated with 10 Die objects.
     */
    public TenziGame() {
        turns = 0;
        startTime = System.currentTimeMillis();
        endTime = 0;
        theDice = new ArrayList<Die>();

        for(int i = 0; i<10;i++) {
            Die die = new Die();
            theDice.add(die);
            die.roll();
        }

    }

    /**
     * @return true if every Die object in the theDice has the same faceValue, false otherwise.
     * Uses Die class.
     */
    public boolean isOver() {
        Die first = theDice.get(0);
        for(int i = 1; i < theDice.size(); i++) {
            if(theDice.get(i).compareTo(first) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param dies, takes in int[] of indexes of dies that user wants to roll
     * a new Die object is created, rolled and set in place of indexes user wanted rolled.
     * Each time roll() is called a turn is used.
     */
    public void roll(int[] dies) {
        turns = turns + 1;
        for(int i = 0; i < dies.length; i++) {
            Die newDie = new Die();
            newDie.roll();
            theDice.set(dies[i], newDie);
        }

    }

    /**
     * Resets all Die objects to random face value.
     * Used when a new game is started.
     */
    public void rollTheDice() {
        for(int i = 0; i< theDice.size(); i++) {
            theDice.get(i).roll();
        }
    }

    /**
     * @return long, of time elapsed
     * endTime is set to current time when a game is over.
     * Then time elapsed is calculated by subtracting startTime from endTime.
     */
    public long getTimeElapsed() {
        endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;

        return timeElapsed;

    }

    /**
     * Resets startTime to the current time of when a new game is started.
     */
    public void resetTime() {
        startTime = System.currentTimeMillis();
    }

    /**
     * resets Turns to 0 when a new game is started.
     */
    public void resetTurns() {
        turns = 0;
    }

    /**
     * @return int turns
     * returns number of turns used.
     */
    public int getTurns() {
        return turns;

    }



    /**
     *Returns a String of the dice board. 
     *
     */
    public String toString() {
        String board = "";
        for(int i = 0; i<theDice.size() ; i++) {
            board = board + i +":" + theDice.get(i).toString() + "\n";

        }
        return board;


    }

}
