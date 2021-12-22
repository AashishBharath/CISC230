
public class Assignments {

    public static void main(String[] args) {
        BasicDate date = new BasicDate(5,1,2005);
        System.out.println(date.toYYYYMMDD());
        
        
        //Every class extends Object
        Object date2 = new BasicDate(5,1,2005);
        
        BasicDate date3 = (BasicDate) date2;
        //This^ can still fail
        
        Object date4 = "12/20/1995";
        BasicDate date5 = (BasicDate)date4;
        //RUNTIME Error^
    }

}
