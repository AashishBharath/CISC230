
public class BirthInformation extends BasicDate {
    
    private String placeOfBirth;
    
    
    public BirthInformation(int month, int day, int year, String place) {
        super (month, day, year);
        placeOfBirth = place;        
    }
    
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }
    
    @Override
    public String toString() {
        return super.toString() + " @ " + placeOfBirth;
    }

}
