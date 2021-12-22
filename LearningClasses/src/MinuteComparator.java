import java.util.Comparator;

public class MinuteComparator implements Comparator<MilitaryTime> {

    @Override
    public int compare(MilitaryTime arg0, MilitaryTime arg1) {
        //Generated getter for minutes in MilitaryTime class
        
        if(arg0.getMinutes() < arg1.getMinutes()) {
            return -1;
        }else if(arg0.getMinutes() > arg1.getMinutes()) {
            return 1;
        }
        return 0;
    }

   
  

   

}
