 
public class BasicDate {
	//instance Variables
	//MUST HAVE JAVA.COMMETN FOR EACH INSTANCE VARIABLE
	private int month;
	private int day;
	private int year;
	
	
	//Constructors
	public BasicDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		
	}

	
	//Methods
	public boolean isSameDate(BasicDate other) {
		//this versus other
		if(this.month == other.month && this.day == other.day && this.year == other.year) {
			return true;
		}
		return false;
		
	}
	public boolean isEarlier(BasicDate other) {
		//is this an earlier date than other
		int thisAsInteger = Integer.parseInt(this.toYYYYMMDD());
		int otherAsInteger = Integer.parseInt(other.toYYYYMMDD());
		if(thisAsInteger < otherAsInteger) {
			return true;
			
		}
		return false;
	}
	
	public String toYYYYMMDD() {
		String returnString = "";
		
		returnString = returnString + year;
		if(month<10) {
			returnString = returnString + "0" +month;
		}else {
			returnString = returnString +month;
		}
		if(day<10) {
			returnString = returnString + "0" +day;
		}else {
			returnString = returnString + day;
		}
		
		
		return returnString; 
	}

	@Override
	public String toString() {
		return month + "/" + day + "/" + year;
	}


    public int getMonth() {
        return month;
    }


    public int getDay() {
        return day;
    }


    public int getYear() {
        return year;
    }
    
    @Override
    public boolean equals(Object other) {
        if(other==null) {
            return false;
        }else if(other.getClass() != this.getClass()) {
            return false;
        }
        
        BasicDate otherAsBasicDate = (BasicDate) other;
        if(this.month == otherAsBasicDate.month && this.day == otherAsBasicDate.day && this.year == otherAsBasicDate.year) {
            return true;
        }
        return false;
    }
	

}
