
/**
 *  TodoItem creates an object is represented with a Date object, Importance Level object , and A description (String).
 *  TodoItem Object can also be created from a properly ordered CSV.
 *  
 * @author Aashish Bharath
 *
 */
public class TodoItem {
    /**Date Object that represents the date of the TodoItem*/
    private Date date;
    /**Importance Object that represents the importance of the TodoItem*/
    private Importance importanceLevel;
    /**holds the description of the TodoItem. Will not contain commas. */
    private String description;
    
    /**
     * @param date Date object representing Date
     * @param description String representing the TodoItem description 
     * @param importanceLevel Importance object representing Importance
     */
    public TodoItem(Date date, String description, Importance importanceLevel) {
        this.date = date;
        this.description = description;
        this.importanceLevel = importanceLevel;
    }
    
    /**
     * This static facotry method will take in a String that is comma seperated, and create a TodoItem.
     * It will catch any errors with the String CSV and throw an IllegalArgumentException.
     * 
     * @param line should be comma seperated string(Ex. 20201121,hello,HIGH)
     * @return TodoItem newItem a new TodoItem is created from the CSV
     */
    public static TodoItem buildFromCSV(String line) {
        String[] lineAsArray = line.split(",");
        Importance newImportanceObject = null;
        Date newDateObject = null;
        try {
            if(lineAsArray[0].contains("-")) {
                newDateObject = Date.fromYYYYMMDDDashString(lineAsArray[0]);
            }else {
                newDateObject = Date.fromYYYYMMDD(lineAsArray[0]);
            }
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        
        
            if(lineAsArray[2].equals("HIGH")) {
                newImportanceObject = Importance.HIGH;
            }else if(lineAsArray[2].equals("MEDIUM")) {
                newImportanceObject = Importance.MEDIUM;
            }else if(lineAsArray[2].equals("LOW")){
                newImportanceObject = Importance.LOW;
            }else {
                throw new IllegalArgumentException();
            }
        
        
        TodoItem newItem = new TodoItem(newDateObject, lineAsArray[1], newImportanceObject);
        return newItem;
        
    }
    
    /**
     * This method converts each instance variable to String(if needed) and returns them all in one string only separated by a comma.
     * @return String a representation of the TodoItem is CSV form
     */
    public String getAsCSV() {
        return date.getAsYYYYMMDD() + "," + description + "," + importanceLevel.toString();
    }
    
    
    /**
     * Method returns the date object in the current TodoItem.
     * @return Date date
     */
    public Date getDate() {
        return date;
    }
    
    
    /**
     * Method returns the Importance object in the current TodoItem.
     * @return Importance importanceLevel
     */
    public Importance getImportanceLevel() {
        return importanceLevel;
    }
    
    
    /**
     * Method returns the description in the current TodoItem.
     * @return String description
     */
    public String getDescription() {
        return description;
    }
    
    
    /**
     *This is a representation of how the TodoItem should be viewed inside of the program.
     *Date comes first, then Importance Level, and finally the description.  
     *Ex.)*
             Date: 4/14/2021
             Importance: HIGH
             Ace CISC 230 exam
     * @return toDoItem a String representation of the TodoItem in question. 
     */
    @Override
    public String toString() {
        String toDoItem;
        toDoItem = "*\n" + "  Date: " + getDate() + "\n" + "  Importance:" + getImportanceLevel() + "\n" + "  " + getDescription() + "\n\n";
        return toDoItem;
    }

}
