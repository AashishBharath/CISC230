
public class DateDriver {

	public static void main(String[] args) {
		BasicDate date1 = new BasicDate(2,01,2002);
		BasicDate date2 = new BasicDate(2,21,2021);
		BasicDate date3 = new BasicDate(2,1,2002);
		
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date1.equals(date2));
		System.out.println(date1.equals(date3));

		System.out.println(date1.toYYYYMMDD());
		
		System.out.println(date1.isEarlier(date3));
		System.out.println(date1.isEarlier(date2));
	}

}
