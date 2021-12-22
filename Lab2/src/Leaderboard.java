import java.util.ArrayList;

/**
 * Leaderboard class. Contains bestTimes used in TenziDriver. 
 * @author Aashish Bharath
 *
 */
public class Leaderboard {
    /**
     * Holds a list of best times that user has had.
     */
    private ArrayList<Long> bestTimes;


    /**
     * Initializes bestTimes as a new ArrayList of longs.
     */
    public Leaderboard() {
        bestTimes = new ArrayList<Long>();
    }

    /**
     * @param newTime time it took user to finish a game.
     * adds new time to the array list of best times. 
     */
    public void update(long newTime) {
        bestTimes.add(newTime);

    }

    /**
     * Selection Sort.
     * Sorts best times in array list in ascending order.
     */
    public void sortTimes() {

        for(int i = 0; i < bestTimes.size();i++) {
            long minimum = bestTimes.get(i);
            int minimumIndex = i;
            for(int j = i+1; j< bestTimes.size(); j ++) {
                if(bestTimes.get(j) < minimum) {
                    minimum = bestTimes.get(j);
                    minimumIndex = j;
                }
            }
            long holder = bestTimes.get(i);
            bestTimes.set(i, minimum);
            bestTimes.set(minimumIndex, holder);

        }
    }

    /**
     * @param time takes in a time in millisecond/long form
     * @return a time in second/double form
     * 
     * Ensures that time shown on screen is in seconds and contains decimal points. 
     */
    public double decimalTime(long time) {
        return (double) time/1000.0;
    }

    /**
     *Returns string of the Leader Board.
     *Best times are listed in ascending order. 
     */
    public String toString() {
        String leaderboard = "";
        leaderboard = leaderboard + "-- Current Leaderboard (in seconds) --\n";
        for(int i = 1; i<=bestTimes.size();i++) {
            leaderboard = leaderboard + i + ". " + decimalTime(bestTimes.get(i-1)) +"\n";
        }
        return leaderboard;
    }

}
