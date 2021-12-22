import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWords {

    public static void main(String[] args) {
        Scanner fileScan;
        File myFile = new File("quick.txt");
        int counter = 0;
        
        try {
            fileScan = new Scanner(myFile);
        } catch(FileNotFoundException e){
            System.out.println("Problem reading file");
            return;
        }
        //Counts every "the"
        while(fileScan.hasNext()) {
            
            String currentWord = fileScan.next();
            if(currentWord.equalsIgnoreCase("the")) {
               counter = counter + 1; 
            }
        }
        System.out.println(counter);
    }

}
