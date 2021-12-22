import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SentenceReader {

    public static void main(String[] args) {
        Scanner fileReader;
        File myFile = new File("quick.txt");
        try {
            fileReader = new Scanner(myFile);
        } catch(FileNotFoundException e) {
            System.out.println("File Not Found");
            return;
        }
        
        
        String currentLine;
        //LINEBYLINE
       
        while(fileReader.hasNextLine()) {
           currentLine = fileReader.nextLine();
           System.out.println(currentLine.toUpperCase());
           
        }
        
        
        
        
    }

}
