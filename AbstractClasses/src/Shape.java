
public abstract class Shape {
    
    private String name;//rectangle
    
    public Shape(String name) {
        this.name = name;
    }
    
    public abstract double computeArea();
    
    public String toString() {
        return "Hi, I am a " + name;
    }
}
