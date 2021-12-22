
public class TextDocument {
    private String currentText;
    private StringStack previousVersions;
    
    public TextDocument() {
        currentText = "";
        previousVersions = new StringStack();
    }
    
    public void addLine(String line) {
        //Save current text
        previousVersions.push(currentText);
        //update current text
        currentText = currentText + line + "\n";
    }
    public void undo() {
        String previous = previousVersions.pop();
        if(previous != null) {
            currentText = previous;
        }
    }
    
    @Override
    public String toString() {
        return currentText; 
    }

}
