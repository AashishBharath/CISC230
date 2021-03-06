import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * This is the driver code that implements the solving of Futoshiki Puzzles.
 * The program first asks the user to enter a puzzle number (file name of the puzzle they wish to solve).
 * Next, the user has choice to solve the puzzle sequentially or using the Fork/Join framework.
 * The program will try to solve the puzzle, and if it is solved, the solved puzzled will be displayed along with the time it took to solve.
 * If the puzzle is not solvable then "Impossible to solve" is printed. 
 * @author Aashish Bharath
 *
 */
public class FutoshikiDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        String fileName;
        String solveChoice;
        long startTime;
        long endTime;
        
        Puzzle newPuzzle = null;
        System.out.println("Welcome to the Futoshiki solver");
        System.out.print("Enter a puzzle number: ");
        fileName = keyboard.nextLine();
        
        try {
            newPuzzle = Puzzle.fromFile(fileName +".txt");
        } catch(IllegalArgumentException e) {
            System.out.println("Problem reading file");
            return;
        }
        System.out.println(newPuzzle);
        
        
        System.out.println("How would you like to solve the puzzle");
        System.out.println("1. Sequential");
        System.out.println("2. Fork/Join");
       
        solveChoice = keyboard.nextLine();
        
        if(solveChoice.equals("1")) {
            System.out.println("Solving Seque ntially...");
            startTime = System.currentTimeMillis();
            
            newPuzzle = Puzzle.solve(newPuzzle, 0);
            
            endTime = System.currentTimeMillis();
            
            if(newPuzzle.isSolved()) {
                System.out.println(newPuzzle);
                System.out.println("Solution found in " + (endTime - startTime)/1000.0 + " seconds");
            }else {
                System.out.println("Impossible to solve");
            }
            
            
        }else if(solveChoice.equals("2")) {
            System.out.println("Solving with Fork/Join...");
            startTime = System.currentTimeMillis();
            
            PuzzleSolver initial = new PuzzleSolver(newPuzzle, 0);
            ForkJoinPool.commonPool().invoke(initial);
            endTime = System.currentTimeMillis();
            
            if(initial.getPuzzleAnswer().isSolved()) {
                System.out.println(initial.getPuzzleAnswer());
                System.out.println("Solution found in " + (endTime - startTime)/1000.0 + " seconds");

            }else {
                System.out.println("Impossible to solve");
            }

          

        }
                
        else {
            System.out.println("Bad Choice");
        }
        
    }
    
    

}
