
public class Rectangle implements HasArea {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double computeArea() {
        return height*width;
    }
}
