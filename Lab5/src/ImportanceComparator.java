import java.util.Comparator;

/**
 * ImportanceComparator implements the Comparable class.
 * Allows program to compare Importance levels. 
 * 
 * @author Aashish Bharath
 *
 */
public class ImportanceComparator implements Comparator<Importance> {

    /**
     *Compares two different Importance levels. 
     *Based on the Importance(arg1, and arg2) compare() will return an int.
     *return ints range from -2 through 2. This is because the highest(or lowest) and importance level can be from another importance is 2 or -2.
     *Returns 0 if they are equal.
     */
    @Override
    public int compare(Importance arg1, Importance arg2) {
        if(arg1.equals(Importance.HIGH)) {
            if(arg2.equals(Importance.LOW)) {
                return -2;
            }else if(arg2.equals(Importance.MEDIUM)) {
                return -1;
            }
        }else if(arg1.equals(Importance.MEDIUM)) {
            if(arg2.equals(Importance.LOW)) {
                return -1;
            }else if(arg2.equals(Importance.HIGH)) {
                return 1;
            }
        }else if(arg1.equals(Importance.LOW)) {
            if(arg2.equals(Importance.HIGH)) {
                return 2;
            }else if(arg2.equals(Importance.MEDIUM)) {
                return 1;
            }
        }
         return 0;
        
 
    }

}
