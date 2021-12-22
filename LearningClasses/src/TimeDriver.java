import java.util.Arrays;

public class TimeDriver {

    public static void main(String[] args) {
        MilitaryTime[] meetings = new MilitaryTime[5];
        meetings[0] = new MilitaryTime(12,0);
        meetings[1] = new MilitaryTime(6,30);
        meetings[2] = new MilitaryTime(5,15);
        meetings[3] = new MilitaryTime(18, 45);
        meetings[4] = new MilitaryTime(13, 5);
        
        Arrays.sort(meetings);
        
        System.out.println(Arrays.toString(meetings));

    }

}
