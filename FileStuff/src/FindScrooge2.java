import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FindScrooge2 {

    public static void main(String[] args) {
        List<String> theLines;
        int lineNumber = 0;
     
        
        try {
            theLines = Files.readAllLines(Paths.get("xmas.txt"), StandardCharsets.UTF_8);
        } catch(IOException e) {
            System.out.println("Problem reading file");
            return;
        }
        
        
        for(String currentLine : theLines) {
            lineNumber = lineNumber + 1;
            if(currentLine.toLowerCase().contains("scrooge")) {
                System.out.println(lineNumber + ":" + currentLine);
                System.out.println("------------------");
            }
        }
        
    }

}
