import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShortNames {

    public static void main(String[] args) {
        List<String> theLines;
        ArrayList<String> shortNames = new ArrayList<String>();
        
        //Reading from a csv file
        try {
            theLines = Files.readAllLines(Paths.get("yob2015.txt"), StandardCharsets.UTF_8);
        } catch(IOException e) {
            System.out.println("Problem reading file");
            return;
        }
        
        
        
        //Getting values from file
        /*for(int i = 0;i<theLines.size();i++) {
            String currentLine = theLines.get(i);
            // "Emma,F,203355"
            String [] parts = currentLine.split(",");
            //["Emma","F", "203355"]
            if(parts[0].length()<=3) {
                shortNames.add(parts[0]);
            }
        }*/
        
        //For Each Loop!
        for(String currentLine : theLines) {
            String [] parts = currentLine.split(",");
            if(parts[0].length()<=3) {
                shortNames.add(parts[0]);
            }
        }
        
        System.out.println("There were " + shortNames.size() + " short names");
        
        String toWrite = "";
        for(String currentName : shortNames) {
            toWrite = toWrite + currentName + "\n";
        }
        
        
       
        try {
            //Creates new file called Short.txt
            //Inputs the string toWrite into the file
            Files.write(Paths.get("short.txt"), toWrite.getBytes(StandardCharsets.UTF_8));
        } catch(IOException e) {
            System.out.println("Problem writing file");
            return;
        }
        
        
    }

}
