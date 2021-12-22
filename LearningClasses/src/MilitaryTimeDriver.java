import java.util.Arrays;
import java.util.Comparator;

public class MilitaryTimeDriver {

	public static void main(String[] args) {
		MilitaryTime time1 = new MilitaryTime(13,5);
		MilitaryTime time2 = new MilitaryTime(12,45);
		MilitaryTime time3 = new MilitaryTime(14,59);
		MilitaryTime time4 = new MilitaryTime(15,01);
		MilitaryTime time5 = new MilitaryTime(23,00);
		
		MilitaryTime[] times = new MilitaryTime[5];
		times[0] = time1;
		times[1] = time2;
		times[2] = time5;
		times[3] = time4;
		times[4] = time3;
		
		Arrays.sort(times);
		System.out.println(Arrays.toString(times));
		
		MilitaryTime[] times2 = new MilitaryTime[5];
		Comparator<MilitaryTime> comparisonBox = new MinuteComparator();
		times2[0] = time1;
        times2[1] = time2;
        times2[2] = time5;
        times2[3] = time4;
        times2[4] = time3;
		
		Arrays.sort(times2, comparisonBox);
		System.out.println(Arrays.toString(times2));
	}

}
