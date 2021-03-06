import java.util.ArrayList; 
import java.util.concurrent.RecursiveAction;

/**
 * This class solves Futoshiki puzzles using the RecursiveAction class.
 * 
 * The PuzzleSolver class represents a Puzzle Object in conjunction with a spot and that Puzzles answer.
 * The PuzzleSolver class will attempt to solve the Puzzle object from that specific spot. The Puzzles eventual answer
 * will be a part of the PuzzleSolver object as well. 
 * 
 * @author Aashish Bharath
 *
 */
public class PuzzleSolver extends RecursiveAction {
    /**
     *Threshold for which a puzzle will be solved sequentially.  
     */
    public static final int THRESHOLD = 20;
    /**
     *The puzzle object that is trying to be solved. 
     */
    private Puzzle newPuzzle;
    /**
     *The current spot from which newPuzzle should be solved from. 
     */
    private int currentSpot;
    
    /**
     * Puzzle object that will eventually hold the answer to newPuzzle.
     */
    private Puzzle puzzleAnswer;
    
    
    /**
     * @param puzzle unsolved puzzle that needs to be solved.
     * @param spot spot from which the class should start solving from.
     * newPuzzle gets instantiated to puzzle, the "empty" puzzle  
     * currentSpot gets instantiated to spot, the spot that the puzzle should be solved from
     * puzzleAnswer is set to null because if the answer to newPuzzle is not found in compute() the puzzleAnswer will be null.  
     */
    public PuzzleSolver(Puzzle puzzle, int spot) {
        newPuzzle = puzzle;
        currentSpot = spot;
        puzzleAnswer = null;
        
    }
    
    /**
     * Getter for the puzzleAnswer which is set to either the answer to newPuzzle or null. 
     * 
     * @return puzzleAnswer Puzzle.
     */
    public Puzzle getPuzzleAnswer() {
        return puzzleAnswer;
    }
    

    /**
     *This compute() method overrides compute() from the Recursive Action class, and it implements the fork/join framework.
     *The method will split newPuzzle, which is an n-by-n puzzle, into n parts by creating new PuzzleSolver objects. 
     *Each new PuzzleSolver object will get a copy of newPuzzle with values 1-n placed in the first available spot. Additionally each new PuzzleSolver object is incremented by one.
     *The method will continue forking and joining until the forked/joined PuzzleSolver objects reaches the threshold of 20. Then the Puzzle in each PuzzleSolver is solved sequentially.
     *
     *No matter what route the compute method takes puzzleAnswer will always be set. puzzleAnswer will either be set to a solved puzzle or null(if puzzle is unsolvable). 
     */
    @Override
    protected void compute() {
        int puzzleSize = newPuzzle.getSize();
        
        if(puzzleSize*puzzleSize - currentSpot <= THRESHOLD) {
            puzzleAnswer = Puzzle.solve(newPuzzle, currentSpot);
            
        }else {
            ArrayList<PuzzleSolver> puzzleParts = new ArrayList<PuzzleSolver>();
            int currentRow = currentSpot/puzzleSize;
            int currentColumn = currentSpot%puzzleSize;
            if(newPuzzle.getValue(currentRow, currentColumn) == Puzzle.EMPTY) {
                for(int i = 1; i <= puzzleSize; i++) {
                    Puzzle puzzleCopy = new Puzzle(newPuzzle);
                    puzzleCopy.insertValue(currentRow, currentColumn, i);
                    
                    if (puzzleCopy.isValid()==true) {
                        PuzzleSolver helper = new PuzzleSolver(puzzleCopy, currentSpot+1);
                        puzzleParts.add(helper);
                    } 
                              
                }
                
                for(int i = 0; i<puzzleParts.size();i++) {
                    //System.out.println("Forking...");
                    puzzleParts.get(i).fork();
                }
                
                for(int i = 0;i<puzzleParts.size();i++) {
                    //System.out.println("Joining...");
                    puzzleParts.get(i).join();
                }
                 for(int i = 0; i<puzzleParts.size(); i++) {
                    if(puzzleParts.get(i).getPuzzleAnswer() != null) {
                        puzzleAnswer = puzzleParts.get(i).getPuzzleAnswer();
                    }
                }
            }else {
                Puzzle puzzleCopy = new Puzzle(newPuzzle);
                PuzzleSolver elseHelper = new PuzzleSolver(puzzleCopy, currentSpot+1);
                elseHelper.compute();
                puzzleAnswer = elseHelper.getPuzzleAnswer();
            }
            
        }
        
    }
   
    
    
}
