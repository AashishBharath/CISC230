import java.util.Comparator;

/**
 * The Date Comparator allows two dates to be compared to each other. 
 * @author Aashish Bharath
 *
 */
public class DateComparator implements Comparator<Date> {

    /**
     *Uses the compareTo method found in the Date class. 
     *returns -1 if arg1<arg2
     *returns 0 if arg1=arg2
     *returns 1 if arg1>arg2
     */
    @Override
    public int compare(Date arg1, Date arg2) {
        return arg1.compareTo(arg2);
    }

}
