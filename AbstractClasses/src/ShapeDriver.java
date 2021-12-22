
public class ShapeDriver {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5.0,4.0);
        Circle c = new Circle(5.0);
        Square s = new Square(10.0);
        RightTriangle t = new RightTriangle(5.0, 4.0);
        
        System.out.println(r);
        System.out.println(c);
        System.out.println(s);
        System.out.println(t);
        
        printArea(r);
        printArea(c);
        printArea(s);
        printArea(t);
        
    }
    
    public static void printArea(HasArea theShape) {
        System.out.println("The area is " + theShape.computeArea());
    }

}
