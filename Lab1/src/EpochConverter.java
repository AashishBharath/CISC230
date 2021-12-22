import java.util.Random;
import java.util.Scanner;

/**
 * 
 * This is an Epoch Time Converter. 
 * It first welcomes the user to the program, and displays the current date.
 * Then, it will prompt the user to enter a month, day, and year.
 * The program will then return that date in Epoch Time and a random date from their given year.
 * 
 * @author Aashish Bharath
 *
 */
public class EpochConverter {

    public static void main(String[] args) {
    	System.out.println("Welcome to the Epoch Time Converter.");
    	//test();
    	
    	
    	//CurrentDate
    	long currentTime = (System.currentTimeMillis())/1000;
    	String currentDate = dateToString(epochTimeToDate(currentTime));
    	System.out.println("Today is " + currentDate);
    	
    	//User input
    	Scanner keyboard = new Scanner(System.in);
    	
    	System.out.print("Enter a month: ");
    	int month = keyboard.nextInt();
    	
    	System.out.print("Enter a day: ");
    	int day = keyboard.nextInt();
    	
    	System.out.print("Enter a year: ");
    	int year = keyboard.nextInt();
    	
    	int[] dateToBeConverted = {month, day, year};
    	
    	//Validity
    	if(isValidDate(dateToBeConverted)== false) {
    		System.out.println("Sorry, invalid date. Goodbye.");
    	}else {
    	//EpochTime
    	System.out.println("That date in Epoch time is " + dateToEpochTime(dateToBeConverted));
    	
    	
    	//RandomDate
    	System.out.println("A randomly generated date from that year is " + dateToString(randomDate(year)));
    	
    	}
    	
    }
    
    
    
    
    /**
     * Checks if a specific year is a leap year.
     * @param year checks if this year is a leap year
     * @return true if it is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
    	if(year%4 == 0){
    		if(year%100 == 0){
    			if(year%400 == 0) {
    				return true;
    			}else {
    				return false;
    			}
    		}else {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * @param date is checked to see if it is a valid date
     * Example Valid Date would be 3/3/2001
     * Example invalid date would be 0/3/2001 or 2/30/2021
     * 
     * @return true if date is valid, false otherwise.
     */
    public static boolean isValidDate (int[] date) {
    	int month = date[0];
    	int day = date[1];
    	int year = date[2];
    	
    	if(month<=12 && month >= 1) {
    		if(day<=31 && day>=1) {
    			//If statements based on if it is a leap year.
    			if(isLeapYear(year) == true) {
    				if(month == 2 && day > 29) {
    					return false;
    				}
    				if(month <= 7) {
    					if(month % 2 == 0 && day > 30) {
    						return false;
    					}else if(month % 2 == 1) {
    						return true;
    					}return true;
    				}else if(month >= 8) {
    					if(month % 2 == 1 && day > 30) {
    						return false;
    					}else if(month % 2 == 0) {
    						return true;
    					}
    					return true;
    				}
    				
    			//If statements based on if it is not a leap year.
    			}else if(isLeapYear(year) == false) {
    				if(month == 2 && day > 28) {
    					return false;
    				}else if(month <= 7) {
    					if(month%2 == 0 && day > 30) {
    						return false;
    					}else if(month % 2 == 1) {
    						return true;
    					}return true;
    				}else if(month >= 8) {
    					if(month%2 == 1 && day > 30) {
    						return false;
    					}else if(month % 2 == 0) {
    						return true;
    					}
    					return true;
    				}
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
    
    /**
     * Takes a date in int[] form and returns the next day.
     * @param date is inputed in int[] form 
     * example input {9,19,2021}
     * 
     * @return newDate: returns the next day in int[] form 
     * example output {9,20,2021}
     */
    public static int[] getDayAfter(int[] date) {
    	
    	
    	int[] newDate = {date[0], date[1]+1, date[2]};
    	int month = newDate[0];
    	int day = newDate[1];
    	int year = newDate[2];
    	
    	
    	if(isValidDate(newDate) == true) {
    		return newDate;
    		
    	}if(isLeapYear(year)) {
    		if(month == 2 && day > 29) {
    			newDate[0] = month + 1;
    			newDate[1] = 01;
    		}
    	}
    	else if(month == 2 && day >= 29) {
			newDate[0] = month + 1;
			newDate[1] = 01;
		}
    	
    	if(isValidDate(newDate)== false) {
    		if(month == 12 && day >= 31) {
    			newDate[0] = 01;
    			newDate[1] = 01;
    			newDate[2] = year + 1;
    		}else if(month<=7) {
    			if(month%2 == 0 && day > 30) {
    				newDate[0] = month + 1;
    				newDate[1] = 01;
    			}else if(month %2 == 1 && day > 31) {
    				newDate[0] = month + 1;
    				newDate[1] = 1;
    			}
    		}else if(month >= 8) {
    			if(month%2 == 0 && day > 31) {
    				newDate[0] = month + 1;
    				newDate[1] = 01;
    			}else if (month % 2 == 1 && day > 30) {
    				newDate[0] = month + 1;
    				newDate[1] = 01;
    			}
    		}else if(month == 2 && day > 29) {
    			newDate[0] = month + 1;
    			newDate[1] = 01;
    		}
    	}
    	return newDate;
    }
    
    
    /**
     * Compares two dates
     * 
     * @param date1 date in int[] form
     * @param date2 date in int[] form
     * @return -1 if date1 is before date2, 1 if date1 is after date2, and 0 if both dates are the same.
     */
    public static int compareDates(int[] date1, int[] date2) {
    	int year1 = date1[2];
    	int year2 = date2[2];
    	int day1 = date1[1];
    	int day2 = date2[1];
    	int month1 = date1[0];
    	int month2 = date2[0];
    	
    	
    	if(year1<year2) {
    		return -1;
    	}else if(year1>year2) {
    		return 1;
    	}else if(year1 == year2) {
    		if(month1<month2) {
    			return -1;
    		}else if(month1>month2) {
    			return 1;
    		}else if(month1 == month2) {
    			if(day1 < day2) {
    				return -1;
    			}else if(day1>day2) {
    				return 1;
    			}else {
    				return 0;
    			}
    		}
    	}
    	return 0;
    }
    
    
    /**
     * Takes array with {month, day, year} and turns into a string "month/day/year"
     * @param date array length: 3 {month, day, year}
     * @return converted array into string of form "month/day/year"
     */
    public static String dateToString(int[] date) {
    	return date[0] + "/" + date[1] +"/" + date[2];
    	
    }
    
    

    /**
     * Count the number of days in between 12:00:00 AM on date1
     * and 12:00:00 AM on date2
     * 
     * @param date1 int[] form, 
     * @param date2 int[] form
     * @return numberOfDays in between date1 and date2
     * 
     * Example: daysBetweenDates({1,1,2021}, {1,3,2021}) returns 2
     */
    public static int daysBetweenDates(int[] date1, int[] date2) {
    	int numberOfDays = 0;
    	int compareDates = compareDates(date1, date2);
    	
    	
    	if(compareDates == -1) {
    		//numberOfDays = numberOfDays + 1;
    		while(compareDates(date1, date2) != 0) {
    			numberOfDays = numberOfDays + 1;
    			date1 = getDayAfter(date1);
    		}
    	}
    	else if(compareDates == 1) {
    		//numberOfDays = numberOfDays + 1;
    		while(compareDates(date1, date2) != 0) {
    			numberOfDays = numberOfDays + 1;
    			date2 = getDayAfter(date2);
    		}
    	}
    	
    	return numberOfDays;
    }
    
    
    /**
     * Converts a date in int[] form to Epoch Time
     * 
     * @param date in int[] form
     * @return epochTime 
     * Date converted to epoch time by calculating how many seconds has elapsed
     * from 1/1/1970 to input parameter: date
     * 
     */
    public static long dateToEpochTime(int[] date) {
    	long epochTime;
    	long daysBetween;
    	int[] startingDate = {1,1,1970};
    	int secondsInADay = 86400;
    	
    	daysBetween = daysBetweenDates(startingDate, date);
    	epochTime = daysBetween * secondsInADay;
    	
    	if(date[2]<1970) {
    		epochTime = epochTime * -1;
    	}
    	return epochTime;
    }
    
    
    
    /**Converts epoch time to date.
     * @param epochTime long variable represents how many seconds have elapsed since 1/1/1970
     * @return int[] currentDate
     * 
     * Uses geDayAfter() method to reach the desired date. getDayAfter() in the while loop stops once numberOfDays
     * is reached. 
     */
    public static int[] epochTimeToDate(long epochTime) {
    	long numberOfDays = epochTime/86400;
    	long counter = 1;
    	int[] currentDate = {1,1,1970};
    	while(counter <= numberOfDays) {
    		currentDate = getDayAfter(currentDate);
    		counter = counter + 1;
    	}
    	return currentDate;
    }
    
    
    /**
     * @param year is a specific year that date will be found in.
     * @param dayNumber is the specific dayNumber in question. 
     * @return currentDate: (1/1/year + dayNumber)
     * 
     * Current date is the specific dayNumber in the specific year.
     * Example dayNumberToDate(2021, 15) will return {1,15,2021}
     */
    public static int[] dayNumberToDate(int year, int dayNumber) {
    	int[] currentDate = {1,1,year};
    	int counter = 1;
    	while(counter < dayNumber) {
    		currentDate = getDayAfter(currentDate);
    		counter = counter + 1;
    		
    	}
    	return currentDate;
    }
    
    
    /**
     * Return random date from a given year.
     * @param year from which random date is generated. 
     * @return a randomDay from given year. 
     * Method checks if year is a leapYear or not to see if that year
     * will have 365 or 366 days. 
     * 
     */
    public static int[] randomDate(int year) {
    	Random generator = new Random();
    	int randomDay;
    	
    	if(isLeapYear(year)) {
    		randomDay = generator.nextInt(367);
    	}else {
    		randomDay = generator.nextInt(366);
    	}
    	return dayNumberToDate(year, randomDay);
    }
    
    public static void test() {
        System.out.println("Testing isLeapYear...");
        System.out.println("isLeapYear(2020) should be true, yours gives "+isLeapYear(2020));
        System.out.println("isLeapYear(1901) should be false, yours gives "+isLeapYear(1901));
        System.out.println("isLeapYear(1800) should be false, yours gives "+isLeapYear(1800));
        System.out.println("isLeapYear(2000) should be true, yours gives "+isLeapYear(2000));
        
        System.out.println("Testing isValidDate...");
        System.out.println("30 day months....");
        System.out.println("isValidDate([9,30,1990]) should be true, yours gives "+isValidDate(new int[] {9,30,1990}));
        System.out.println("isValidDate([9,31,1990]) should be false, yours gives "+isValidDate(new int[] {9,31,1990}));
        System.out.println("isValidDate([11,30,1950]) should be true, yours gives "+isValidDate(new int[] {11,30,1950}));
        System.out.println("isValidDate([11,31,1950]) should be false, yours gives "+isValidDate(new int[] {11,31,1950}));
        System.out.println("isValidDate([4,30,1900]) should be true, yours gives "+isValidDate(new int[] {4,30,1900}));
        System.out.println("isValidDate([4,31,1900]) should be false, yours gives "+isValidDate(new int[] {4,31,1900}));
        System.out.println("isValidDate([6,30,1800]) should be true, yours gives "+isValidDate(new int[] {6,30,1800}));
        System.out.println("isValidDate([6,31,1800]) should be false, yours gives "+isValidDate(new int[] {6,31,1800}));
        System.out.println("February....");
        System.out.println("isValidDate([2,28,2000]) should be true, yours gives "+isValidDate(new int[] {2,28,2000}));
        System.out.println("isValidDate([2,29,2000]) should be true, yours gives "+isValidDate(new int[] {2,29,2000}));
        System.out.println("isValidDate([2,30,2000]) should be false, yours gives "+isValidDate(new int[] {2,30,2000}));
        System.out.println("isValidDate([2,28,2001]) should be true, yours gives "+isValidDate(new int[] {2,28,2001}));
        System.out.println("isValidDate([2,29,2001]) should be false, yours gives "+isValidDate(new int[] {2,29,2001}));
        System.out.println("isValidDate([2,30,2001]) should be false, yours gives "+isValidDate(new int[] {2,30,2001}));
        System.out.println("isValidDate([2,28,1900]) should be true, yours gives "+isValidDate(new int[] {2,28,1900}));
        System.out.println("isValidDate([2,29,1900]) should be false, yours gives "+isValidDate(new int[] {2,29,1900}));
        System.out.println("isValidDate([2,30,1900]) should be false, yours gives "+isValidDate(new int[] {2,30,1900}));
        System.out.println("October - 31 day month");
        System.out.println("isValidDate([10,30,2020]) should be true, yours gives "+isValidDate(new int[] {10,30,2020}));
        System.out.println("isValidDate([10,31,2020]) should be true, yours gives "+isValidDate(new int[] {10,31,2020}));
        System.out.println("Very invalid dates...");
        System.out.println("isValidDate([14,20,2005]) should be false, yours gives "+isValidDate(new int[] {14,20,2005}));
        System.out.println("isValidDate([5,40,2010]) should be false, yours gives "+isValidDate(new int[] {5,40,2010}));
        System.out.println("isValidDate([0,15,2000]) should be false, yours gives "+isValidDate(new int[] {0,15,2000}));
        System.out.println("isValidDate([2,31,2004]) should be false, yours gives "+isValidDate(new int[] {2,31,2004}));
        
        System.out.println("Testing compareDates...");
        System.out.println("compareDates([12,5,2010], [12,5,2010]) should give 0, yours gives "
                +compareDates(new int[] {12,5,2010},new int[] {12,5,2010}));
        System.out.println("compareDates([10,5,2005], [10,5,2010]) should give -1, yours gives "
                +compareDates(new int[] {10,5,2005},new int[] {10,5,2010}));
        System.out.println("compareDates([6,5,2005], [6,5,1910]) should give 1, yours gives "
                +compareDates(new int[] {6,5,2005},new int[] {6,5,1910}));
        System.out.println("compareDates([6,20,2004], [7,5,2004]) should give -1, yours gives "
                +compareDates(new int[] {6,20,2004},new int[] {7,5,2004}));
        System.out.println("compareDates([6,20,2004], [6,5,2004]) should give 1, yours gives "
                +compareDates(new int[] {6,20,2004},new int[] {6,5,2004}));
        System.out.println("Testing getDayAfter...");
        System.out.println("getDayAfter([10,14,2004]) should be 10/15/2004, yours gives "
                +dateToString(getDayAfter(new int[] {10,14,2004})));
        System.out.println("getDayAfter([10,31,2004]) should be 11/1/2004, yours gives "
                +dateToString(getDayAfter(new int[] {10,31,2004})));
        System.out.println("getDayAfter([12,31,2004]) should be 1/1/2005, yours gives "
                +dateToString(getDayAfter(new int[] {12,31,2004})));
        System.out.println("getDayAfter([2,28,2004]) should be 2/29/2004, yours gives "
                +dateToString(getDayAfter(new int[] {2,28,2004})));
        System.out.println("getDayAfter([2,29,2004]) should be 3/1/2004, yours gives "
                +dateToString(getDayAfter(new int[] {2,29,2004})));
        
        System.out.println("Testing dateToEpochTime...");
        System.out.println("dateToEpochTime([1,5,1970]) should be 345600, yours gives "
                +dateToEpochTime(new int[] {1,5,1970}));
        System.out.println("dateToEpochTime([12,20,1970]) should be 30499200, yours gives "
                +dateToEpochTime(new int[] {12,20,1970}));
        System.out.println("dateToEpochTime([6,5,1971]) should be 44928000, yours gives "
                +dateToEpochTime(new int[] {6,5,1971}));
        System.out.println("dateToEpochTime([8,20,1985]) should be 493344000, yours gives "
                +dateToEpochTime(new int[] {8,20,1985}));
        System.out.println("dateToEpochTime([10,10,1996]) should be 844905600, yours gives "
                +dateToEpochTime(new int[] {10,10,1996}));
        System.out.println("dateToEpochTime([3,5,2000]) should be 952214400, yours gives "
                +dateToEpochTime(new int[] {3,5,2000}));
        System.out.println("dateToEpochTime([4,28,2011]) should be 1303948800, yours gives "
                +dateToEpochTime(new int[] {4,28,2011}));
        System.out.println("dateToEpochTime([11,25,2040]) should be 2237414400, yours gives "
                +dateToEpochTime(new int[] {11,25,2040}));
        
        
        System.out.println("dateToEpochTime([12,30,1969]) should be -172800, yours gives "
                +dateToEpochTime(new int[] {12,30,1969}));
        System.out.println("dateToEpochTime([1,2,1969]) should be -31449600, yours gives "
                +dateToEpochTime(new int[] {1,2,1969}));
        System.out.println("dateToEpochTime([10,20,1910]) should be -1868227200, yours gives "
                +dateToEpochTime(new int[] {10,20,1910}));
        System.out.println("dateToEpochTime([1,7,1899]) should be -2240006400, yours gives "
                +dateToEpochTime(new int[] {1,7,1899}));
        System.out.println("dateToEpochTime([7,27,1810]) should be -5031244800, yours gives "
                +dateToEpochTime(new int[] {7,27,1810}));
        
        
        System.out.println("Testing epochTimeToDate on dates after 1/1/1970...");
        
        System.out.println("epochTimeToDate(844905650) should give 10/10/1996, yours gives "
                +dateToString(epochTimeToDate(844905650)));
        System.out.println("epochTimeToDate(1303948700) should give 4/27/2011, yours gives "
                +dateToString(epochTimeToDate(1303948700)));
        System.out.println("epochTimeToDate(2237415800) should give 11/25/2040, yours gives "
                +dateToString(epochTimeToDate(2237415800L)));
        
        System.out.println("Testing dayNumberToDate...");
        System.out.println("dayNumberToDate(2004,1) should give  1/1/2004, yours gives "
                +dateToString(dayNumberToDate(2004,1)));
        System.out.println("dayNumberToDate(2004,60) should give  2/29/2004, yours gives "
                +dateToString(dayNumberToDate(2004,60)));
        System.out.println("dayNumberToDate(2004,61) should give  3/1/2004, yours gives "
                +dateToString(dayNumberToDate(2004,61)));
        System.out.println("dayNumberToDate(2004,366) should give  12/31/2004, yours gives "
                +dateToString(dayNumberToDate(2004,366)));
        
        
        
    }

    
}
