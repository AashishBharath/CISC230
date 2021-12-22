
public enum Grade {
    A(4.0, "A"),
    A_MINUS(3.7, "A-"),
    B_PLUS(3.3, "B+"),
    B(3.0, "B"),
    //... 
    F(0.0, "F");
   
    
    private double qualityPoints;
    private String displayName;
    
    //Can only call constructor in Grade class
    private Grade(double quality, String display) {
        qualityPoints = quality;
        displayName = display;
    }
    
    public double getQualityPoints() {
        return qualityPoints;
    }
    
    @Override
    public String toString() {
        return displayName;
    }

}
