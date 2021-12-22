
public class LetterGrade {
    public static final LetterGrade A = new LetterGrade(4.0, "A");
    public static final LetterGrade A_MINUS = new LetterGrade(3.7, "A-");
    public static final LetterGrade B_PLUS = new LetterGrade(3.3, "B+");
    public static final LetterGrade B = new LetterGrade(3.0, "B");
    //... 
    public static final LetterGrade F = new LetterGrade(0.0, "F");
   
    
    private double qualityPoints;
    private String displayName;
    
    //Can only call constructor in LetterGrade class
    private LetterGrade(double quality, String display) {
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
