
public class Address {
    private int houseNumber;
    private String streetName;
    private String city;
    private String state;
    private int zipCode;
    
    public Address(int houseNumber, String street, String city, String state, int zip) {
        this.houseNumber = houseNumber;
        this.streetName = street;
        this.city = city;
        this.state = state;
        this.zipCode = zip;
    }
    
    public boolean nearby(Address other) {
        if(this.zipCode == other.zipCode) {
            return true;
        }else {
            return false;
        }
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }
    
    @Override
    public String toString() {
        return houseNumber + " " + streetName +", " + city + ", " + state + " " + zipCode;
    }
    
    
    

}
