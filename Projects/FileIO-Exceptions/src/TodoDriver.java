import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * This is the driver that allows a user to view or create a To Do List.
 * The program asks the user for their username and if it exists the user can view the to do list sorted by either Date or Importance level. 
 * They can also add to an existing file. If tasks are added, user will have to save and exit for tasks to be added to the file. 
 * 
 * If the file doesn't exist under the inputed username then the user has the option to create a new file.
 * The user then can add tasks, view the tasks, and finalize to their new file. **User must save and exit for new file to be created.
 * @author Aashish Bharath
 *
 */
public class TodoDriver {

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
       
        TodoList usersList = null;
        TodoItem newTask;
                
        String username;
        String newFileChoice;
        String userChoice;
        String userDateInput;
        String userImportanceInput;
        String userDescription;
        
        Date userDate;
        Importance userImportance;
        
        System.out.println("Welcome to the TodoList application.");
        System.out.print("Enter your username: ");
        username = keyboard.nextLine();
        try {
            usersList = TodoList.buildFromUsername(username);
        } catch(IllegalArgumentException e) {
            System.out.println("An error occured trying to read the file for your username.");
            System.out.print("Create a new Todo List? (Y/N) ");
            newFileChoice = keyboard.nextLine();
            if(newFileChoice.equals("N")) {
                return;
            }else if(newFileChoice.equals("Y")) {
                usersList = new TodoList(username);
            }
        }
        
        while(true) {
            System.out.println("Options:");
            System.out.println("1.) Show Tasks sorted by date");
            System.out.println("2.) Show Tasks sorted by importance");
            System.out.println("3.) Add new task");
            System.out.println("4.) Save and exit");
            System.out.print("Your choice: ");
            userChoice = keyboard.nextLine();
            
            if(userChoice.equals("1")) {
                System.out.println(usersList.getAsDateSortedString());
                
            }else if(userChoice.equals("2")) {
                System.out.println(usersList.getAsImportanceSortedString());
            }else if(userChoice.equals("3")) {                
                //USER CHOICE OF DATE
                System.out.print("Enter a date (YYYY-MM-DD): ");
                userDateInput = keyboard.nextLine();
                //Catches any input other than YYYY-MM-DD format 
                try {
                    userDate = Date.fromYYYYMMDDDashString(userDateInput);
                }catch (IllegalArgumentException e) {
                    System.out.println("Dates must be entered in YYYY-MM-DD format");
                    continue;
                }
                //USER CHOICE OF IMPORTANCE
                System.out.print("Enter an importance (HIGH, MEDIUM, LOW): ");
                userImportanceInput = keyboard.nextLine();
                //Catches any input other than a proper Importance level
                try {
                    userImportance = Importance.valueOf(userImportanceInput);
                    
                } catch(IllegalArgumentException x) {
                    System.out.println("Bad importance choice");
                    continue;
                }
                
                //USER CHOICE OF DESCRIPTION
                System.out.print("Enter a short description (no commas): ");
                userDescription = keyboard.nextLine();
                
                //Catches commas
                if(userDescription.contains(",")) {
                    System.out.println("No commas allowed");
                    continue;
                }
                
                newTask = new TodoItem(userDate,userDescription,userImportance);
                usersList.addTask(newTask);
                
            }else if(userChoice.equals("4")) {
                usersList.finalize();
                break;
            }
        }





    }
    
        
   

}
