
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
		if(minutes<10) {
			return hours + ":" + "0" + minutes;
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
