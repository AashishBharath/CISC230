import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AverageHighYilek {

    public static void main(String[] args) {
        List<String> lines;
        int[] highs = new int[365];
        try {
            lines = Files.readAllLines(Paths.get("weather2006.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Problem reading file");
            return;
        }
        
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            highs[i] = Integer.parseInt(parts[3]);
            
        }
        
        // calculate the average of the values in highs
        int total = 0;
        for (int i = 0; i < highs.length; i++) {
            total = total + highs[i];
        }
        System.out.println("Average high in 2006 was" +(total/(double)highs.length));
        
    }

}
