import java.util.Scanner;

public class TimeExceptions {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userInput;
        MilitaryTime theTime = null;
        try {
            System.out.print("Enter a time: ");
            userInput = keyboard.nextLine();
            theTime = MilitaryTime.fromAMPMString(userInput);
            System.out.println(theTime);
        }catch(IllegalArgumentException e) {
            System.out.println("Time entered incorrectly");
        }
        
    }

}
