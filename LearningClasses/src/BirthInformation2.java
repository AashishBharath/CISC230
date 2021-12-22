
public class BirthInformation2 {
    private String placeOfBirth;
    private BasicDate dateOfBirth;
    
    public BirthInformation2 (int month, int day, int year, String place) {
        dateOfBirth = new BasicDate(month,day, year);
        placeOfBirth = place;
        
    }
    
    public String toYYMMDD(){
        return dateOfBirth.toYYYYMMDD();
    }
    
    public int getDay() {
        //Forwarding Method
        return dateOfBirth.getDay();
        
    }
    
    public int getMonth() {
        return dateOfBirth.getMonth();
    }
    
    public int getYear() {
        return dateOfBirth.getYear();
    }
    
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }
    
    public String toString() {
        return dateOfBirth.toString() + " @ " + placeOfBirth; 
    }

}
