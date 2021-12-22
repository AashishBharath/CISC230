
public class StringPlay {

	public static void main(String[] args) {
		String greeting1 = "Hello";
		String greeting2 = new String("Hello");
		String greeting3 = "hi";
		
		greeting3 = greeting3 +" there";
		System.out.println(greeting3);
		
		
		//acessing individual chars/string methods
		System.out.println(greeting1.charAt(4));
		System.out.println(greeting1.length());
		//greeting1 = greeting1.toUpperCase();
		System.out.println(greeting1);
		
		
		//string comparison
		if(greeting1.equals(greeting2)) {
			System.out.println("YAY");
		}
		
		String s = "dog";
		System.out.println(s.toUpperCase());

	}

}
