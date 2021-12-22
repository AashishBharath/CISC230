import java.util.Scanner;

/**TenziDriver runs TenziGame, Leaderboard, and Die classes.
 * Simulates a Tenzi-Like game.
 * 
 * @author Aashish Bharath
 *
 */
public class TenziDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TenziGame newGame = new TenziGame();
        Leaderboard leaderBoard = new Leaderboard();

        int[] diceToBeRolled;
        String playAgain;
        String diceChoice;
        long timeElapsed;
        int turns;


        while(newGame.isOver() == false) {
            System.out.println(newGame);
            System.out.print("Which to roll: ");

            diceChoice = keyboard.nextLine();
            diceToBeRolled = splitToInts(diceChoice);
            newGame.roll(diceToBeRolled);



            if(newGame.isOver() == true) {
                System.out.println(newGame);
                timeElapsed = newGame.getTimeElapsed();
                turns = newGame.getTurns();
                leaderBoard.update(timeElapsed);

                System.out.println("Game over. You used " + turns + " turns and " + leaderBoard.decimalTime(timeElapsed) +" seconds.\n");

                leaderBoard.sortTimes();
                System.out.println(leaderBoard);

                System.out.println("Play Again?(Y|N): ");
                playAgain = keyboard.nextLine();

                if(playAgain.equals("Y") || playAgain.equals("y")) {
                    newGame.rollTheDice();
                    newGame.resetTime();
                    newGame.resetTurns();

                }else {
                    break;
                }
            }


        }




    }



    /**
     * @param stringToBeSplit, takes in a string of numbers.
     * 
     * @return an int[] of same numbers from stringToBeSplit, but in int form. 
     */
    public static int[] splitToInts(String stringToBeSplit) {
        String[] splitString;

        splitString = stringToBeSplit.split(",");

        int[] splitNumbers = new int[splitString.length];

        for(int i = 0; i<splitNumbers.length;i++) {
            splitNumbers[i] = Integer.parseInt(splitString[i]);
        }
        return splitNumbers;
    }

}
