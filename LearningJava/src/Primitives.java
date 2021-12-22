
public class Primitives {

	public static void main(String[] args) {
		int x;
		double d;
		char c;
		
		// int vs. double
		x = 5;
		d = x;
		System.out.println("Double d is "+d);
		
		d = 10.75;
		x = (int)d; 
		System.out.println("Int x is "+x);
		
		// int vs. char
		c = 'a';
		x = c;
		System.out.println("Int x is "+x);
		
		x = 98;
		c = (char)x;
		System.out.println("Char c is "+c);
		

	}

}
