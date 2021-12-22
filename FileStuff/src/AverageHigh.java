import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AverageHigh {

    public static void main(String[] args) {
        List<String> theLines = null;
        int addTemps = 0;
        int totalTemps = 0;
        
        try {
            theLines = Files.readAllLines(Paths.get("weather2006.csv"), StandardCharsets.UTF_8);
        }catch(IOException e) {
            System.out.println("Problem Reading File");
            return;
        }
        
        for(String currentLine: theLines) {
            totalTemps = totalTemps + 1;
            String[] splitLines = currentLine.split(",");
            addTemps = addTemps + Integer.parseInt(splitLines[3]);
        }
        System.out.println(addTemps/(double)totalTemps);
    }

}
