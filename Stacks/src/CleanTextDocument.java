
public class CleanTextDocument extends TextDocument {
    
    @Override
    public void addLine(String line) {
        String cleanLine = line.replace("darn", "####");
        
        super.addLine(cleanLine);
    }

}
