import java.util.Scanner;

/**
 * DishIt Driver runs Interpreter and InterpreterMath. The user gets to choose which "language" to interpret.
 * Driver continues to run, until user types ":exit".
 * User must type in DishIt or DishIt-math to access either language.
 * DishIt commands may be used while using DishIt-math.
 * 
 * @author Aashish Bharath
 *
 */
public class DishItDriver {

    public static void main(String[] args) {
      
      Scanner keyboard = new Scanner(System.in);
      Interpreter dishIt;
      String userChoice;
      String[] multipleUserChoice;
      String languageChoice;
      boolean keepRunning;
      keepRunning = true;
     
      

      System.out.print("DishIt or DishIt-math: ");
      languageChoice = keyboard.nextLine();
      if(languageChoice.equals("DishIt")) {
          dishIt = new Interpreter();
      }else if(languageChoice.equals("DishIt-math")){
          dishIt = new InterpreterMath();
      }else {
          keepRunning = false;
          dishIt = new InterpreterMath();
      }
      
      
      while(keepRunning) {
          System.out.print(">>");
          userChoice = keyboard.nextLine();
          
          if(userChoice.equals(":exit")) {
              System.out.println("Goodbye!");
              keepRunning = false;
              break;
          }
          if(userChoice.contains(";")) {
              multipleUserChoice = userChoice.split(";");
              keepRunning = dishIt.evalMultiple(multipleUserChoice);
          }
          
          else {
              keepRunning = dishIt.eval(userChoice);
          }
    
    }
}
}
