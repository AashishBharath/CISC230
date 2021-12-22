
public class RightTriangle implements HasArea {
    
    private double height;
    private double width;

    public RightTriangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    
    @Override
    public double computeArea() {
        return (height*width)/2;
    }

}
