
/**
 * This is the Date class and it implements the Comparable class.
 * Dates are represented by three Integers for Month, Day, and Year.
 * This Date class has static factory methods to create Date objects from a variety of ways. Mostly to fit with reading and writing to files.
 * 
 * @author Aashish Bharath
 *
 */
public class Date implements Comparable<Date>{
    
    /**
     * Private instance variable for month of the date
     */
    private int month;
    /**
     * Private instance variable for day of the date
     */
    private int day;
    /**
     * Private instance variable for year of the date
     */
    private int year;
    
    /**
     * Constructor for date. Intializes month, day and year.
     * @param month int representing the month in the date. 
     * @param day int representing the day in the date.
     * @param year int representing the year in the date.
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    /**
     * The static factory method extracts the month, day, and year from a string in form YYYYMMDD.
     * This are converted into integers and then are inputed in a Date class constructor creating a new Date object.
     * This new Date object is returned.
     * 
     * Catches any and all exceptions regarding an invalid date.
     * @param date String in format YYYYMMDD (Ex. 20211128)
     * @return newDate a Date object that has extracted necessary information from String date.
     */
    public static Date fromYYYYMMDD(String date) {
        String day;
        String month;
        String year;
        int monthAsInt;
        int dayAsInt;
        int yearAsInt;
        
        try {
            day = date.substring(date.length()-2, date.length());
            month = date.substring(date.length()-4, date.length()-2);
            year = date.substring(0, date.length()-4);
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
        
        
        try {
            monthAsInt = Integer.parseInt(month);
            dayAsInt = Integer.parseInt(day);
            yearAsInt = Integer.parseInt(year);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if(dayAsInt < 0 || dayAsInt >31) {
            throw new IllegalArgumentException();
        }else if(monthAsInt < 0 || monthAsInt > 12) {
            throw new IllegalArgumentException();
        }
        
        Date newDate = new Date(monthAsInt, dayAsInt, yearAsInt);
        return newDate;
    }
    
    /**
     * The static factory method extracts the month, day, and year from a string in form YYYY-MM-DD.
     * This are converted into integers and then are inputed in a Date class constructor creating a new Date object.
     * This new Date object is returned.
     * 
     * Any and all exceptions are caught in regards to an invalid date.
     * @param date String in format YYYY-MM-DD (Ex. 2021-11-28)
     * @return newDate a Date object that has extracted necessary information from String date.
     */
    public static Date fromYYYYMMDDDashString(String date) {
        String [] dateAsArray = null;
        int monthAsInt;
        int dayAsInt;
        int yearAsInt;
        
        try {
            dateAsArray = date.split("-");
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        
        if(dateAsArray[0].length() < 4 || dateAsArray[0].length() > 4) {
            throw new IllegalArgumentException();
        }else if(dateAsArray[1].length() < 2 || dateAsArray[1].length() > 2){
            throw new IllegalArgumentException();

        }else if(dateAsArray[2].length() < 2 || dateAsArray[2].length() > 2) {
            throw new IllegalArgumentException();
        }
        
        try {
            yearAsInt = Integer.parseInt(dateAsArray[0]);
            monthAsInt = Integer.parseInt(dateAsArray[1]);
            dayAsInt = Integer.parseInt(dateAsArray[2]);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        
        if(monthAsInt>12 || monthAsInt<0) {
            System.out.println("Bad Month Choice");
            throw new IllegalArgumentException();
        }else if(dayAsInt>31 || dayAsInt<0) {
            System.out.println("Bad Day Choice");
            throw new IllegalArgumentException();
        }
        
        Date newDate = new Date(monthAsInt, dayAsInt, yearAsInt);
        return newDate;
        
    }
    
    /**
     * The method uses the classes instance variables to combine the month, day, and year into a YYYYMMDD format.
     * The numbers are converted to a string to "attach" them, and then it converted back to an int.
     * 
     * @return YYYYMMDD int that is the Date object represented in YYYYMMDD format.
     */
    public int getAsYYYYMMDD() {
        String dateAsString;
        int YYYYMMDD;
        if(day<10 && month<10) {
            dateAsString = "" + year + "0" + month + "0" + day;
            YYYYMMDD = Integer.parseInt(dateAsString);
            return YYYYMMDD;
        }else if(day<10) {
            dateAsString = "" + year + month + "0" + day;
            YYYYMMDD = Integer.parseInt(dateAsString);
            return YYYYMMDD;
        }else if(month<10) {
            dateAsString = "" + year + "0" + month + day;
            YYYYMMDD = Integer.parseInt(dateAsString);
            return YYYYMMDD;
        }
        dateAsString = "" + year + month + day;
        YYYYMMDD = Integer.parseInt(dateAsString);
        return YYYYMMDD;
        
    }
    
    /**
     * This method checks for equality between to Date objects. The getAsYYYYMMDD() method is used.
     * If Object other is not  Date Object then false is returned. 
     * 
     *@param other another Object that will be checked for equality against this Date object. 
     *@return true if this Date object is the same Date as Object other, false otherwise.
     */
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }else if(other.getClass() != this.getClass()) {
            return false;
        }
        Date otherAsDate = (Date) other;
        
        if(this.getAsYYYYMMDD() == otherAsDate.getAsYYYYMMDD()) {
            return true;
        }
        return false;
    }
    
    /**
     *@param other Date object to be compared with this Date object.
     *@return int -1 if this Date object is earlier then the other date object, 1 if this Date object is after the other Date object,
     * and 0 if they are the same Date. 
     */
    @Override
    public int compareTo(Date other) {
        int thisDate;
        int otherDate; 
        thisDate = this.getAsYYYYMMDD();
        otherDate = other.getAsYYYYMMDD();
        if(thisDate < otherDate) {
            return -1;
        }else if(thisDate > otherDate) {
            return 1;
        }
        return 0;
    }
    
    /**
     * toString returns Date object in String format. Used when displaying date to user.
     * Ex. 11/28/2021
     *@return String representation of Date object.
     */
    public String toString() {
        return month + "/" + day + "/" + year;
    }

}
