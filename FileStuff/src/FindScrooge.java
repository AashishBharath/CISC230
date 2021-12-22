import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindScrooge {

    public static void main(String[] args) {
        Scanner fileScan;
        File xmas = new File("xmas.txt");
        int lineNumber = 0;
        
        try {
            fileScan = new Scanner(xmas);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        
        while(fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            lineNumber = lineNumber + 1;
            if(line.toLowerCase().contains("scrooge")){
                System.out.println(lineNumber +": " + line);
                System.out.println("------------");
            }
        }
    }
}