import java.util.Scanner;

/**
 * Problem: Write a program that an instructor could use to see grades 
 * in their class of 10 students.  Have the program ask the user 
 * for 10 scores (between 0-100) and then print to the screen how 
 * many As, Bs, Cs, Ds, and Fs there were.  You might want to 
 * write a method countInRange that could be used like 
 * countInRange(arrayOfScores, 80, 90) to help you.
 * 
 * @author Prof. Yilek
 *
 */
public class GradeSummary {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // to keep things simple we will assume scores are integers 0-100
        int[] scores = new int[10];
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter a score: ");
            scores[i] = keyboard.nextInt();
        }
        
        // Need to use 101 with A, since score of 100 might be possible 
        System.out.println("There were "+countInRange(scores,90,101)+ " As");
        System.out.println("There were "+countInRange(scores,80,90)+ " Bs");
        System.out.println("There were "+countInRange(scores,70,80)+ " Cs");
        System.out.println("There were "+countInRange(scores,60,70)+ " Ds");
        System.out.println("There were "+countInRange(scores,0,60)+ " Fs");

    }
    
    /**
     * This method counts how many scores in the integer array are at least 
     * lower but less than upper.
     * 
     * @param scores An array of scores 0-100
     * @param lower The lower end of the range we are interested in
     * @param upper The upper end of the range we are interested in
     * @return The number of scores in the integer array between lower and upper
     */
    public static int countInRange(int[] scores, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i]>=lower && scores[i]<upper) {
                count = count + 1;
            }
        }
        return count;
    }

}
