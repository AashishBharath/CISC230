
/**
 * Military time class with isEarlier(), isSameTime(), and toString() methods
 * @author Aashish Bharath
 *
 */
public class MilitaryTime implements Comparable<MilitaryTime> {
	/**Hours in Military time(0-23)
	 */
	private int hours;
	/**Minutes in Military time(0-59_
	 */
	private int minutes;
	
	
	
	public int getHours() {
        return hours;
    }


    public int getMinutes() {
        return minutes;
    }


    /**
	 * Implements hours and minutes instance variables
	 * @param hours
	 * @param minutes
	 */
	public MilitaryTime(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public static MilitaryTime fromMilitaryTimeString(String time) {
	    //errors:
	    //wrong number of colons
	    //non-integers
	    //50:12 invalid time
	   
	    int hours;
	    int minutes;
	    String [] parts = time.split(":");
	    //catches wrong number of colons
	    if(parts.length > 2) {
	        throw new IllegalArgumentException();
	    }
	    //catches non-integers
	    try {
	    hours = Integer.parseInt(parts[0]);
	    minutes = Integer.parseInt(parts[1]);
	    } catch(NumberFormatException e) {
	        throw new IllegalArgumentException();
	    }
	    
	    //catches invalid time
	    if(hours < 0 || hours > 23) {
	        throw new IllegalArgumentException();
	    }
	    if(minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException();
        }
	    
	    return new MilitaryTime(hours, minutes);
	}
	
	public static MilitaryTime fromAMPMString(String time) {
	    int hours;
	    int minutes;
	    
	    String amOrPm = time.substring(time.length() - 2);
	    String justTime = time.substring(0, time.length() - 2);
	    
	    String parts[] = justTime.split(":");
	    //catches spaces, wrong number of colons, or wrong format
	    try {
    	    if(parts.length > 2 || parts[1].length()>2) {
                throw new IllegalArgumentException();
            }
	    }catch(ArrayIndexOutOfBoundsException e) {
	        throw new IllegalArgumentException();
	    }
	    
	    //Catches Invalid Integers
	    try {
	        hours = Integer.parseInt(parts[0]);
	        minutes = Integer.parseInt(parts[1]);
	    } catch(NumberFormatException e) {
	            throw new IllegalArgumentException();
	    }
	    //Catches wrong hours or minutes
	    if(hours < 0 || hours>12) {
	        throw new IllegalArgumentException();
	    }else if(minutes<0 || minutes>59) {
	        throw new IllegalArgumentException();
	    }
	    
	    if(amOrPm.equals("pm") && hours<12) {
	        hours = hours + 12;
	    }else if(amOrPm.equals("am") && hours==12) {
	        hours = 0;
	    }
	    //Catches invalid "am" or "pm"
	    if(amOrPm.equals("pm") || amOrPm.equals("am")) {
	        
	    }else {
	        throw new IllegalArgumentException();
	    }
	    
	    return new MilitaryTime(hours, minutes);
	}
	
	/**
	 * Checks if this is the same time as other
	 * @param other
	 * @return
	 */
	public boolean isSameTime(MilitaryTime other) {
		if(this.hours == other.hours && this.minutes == other.minutes) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Checks if this is earlier than other
	 * @param other
	 * @return
	 */
	public boolean isEarlier(MilitaryTime other) {
		if(this.hours < other.hours) {
			return true;
		}else if(this.hours == other.hours && this.minutes < other.minutes) {
			return true;
		}
		return false;
	}
	
	/**Converts instance variables to a string.
	 *
	 */
	public String toString(){
	    String hours = ""+this.hours;
	    String minutes = "" + this.minutes;
		if(this.minutes<10) {
			minutes = "0" + this.minutes;
		}
		if(this.hours < 10) {
		    hours = "0" + this.hours;
		}
		
		return hours +":" + minutes;
	}


    @Override
    public int compareTo(MilitaryTime other) {
        if(this.hours<other.hours) {
            return -1;
        }else if(this.hours == other.hours) {
            if(this.minutes < other.minutes) {
                return -1;
            }else if(this.minutes > other.minutes) {
                return 1;
            }
        }else if(this.hours > other.hours){
            return 1;
        }
        return 0;
    }
    

}
