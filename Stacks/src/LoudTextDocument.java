
public class LoudTextDocument extends TextDocument {
    
    @Override
    public void addLine(String line) {
        String loudLine = line.toUpperCase();
        
        super.addLine(loudLine);
    }


}
