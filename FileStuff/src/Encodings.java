import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encodings {

    public static void main(String[] args) {
        byte[] fileBytes;
        
        try {
            
        fileBytes = Files.readAllBytes(Paths.get("money.txt"));
        } catch(IOException e) {
            System.out.println("Problem reading file");
            return;
        }
        
        String contents = new String(fileBytes, StandardCharsets.UTF_8);
        String contents2 = new String(fileBytes, StandardCharsets.US_ASCII);
        
        System.out.println(contents);
        System.out.println(contents2);
    }

}
