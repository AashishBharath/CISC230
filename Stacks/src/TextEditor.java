import java.util.Scanner;

public class TextEditor {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean keepEditing = true;
        TextDocument currentDocument;
        
        System.out.print("Clean, Regular, or LOUD (C|R|L):");
        String choice = keyboard.nextLine();
        
        if(choice.equals("C")) {
            currentDocument = new CleanTextDocument();
        }else if(choice.equals("L")) {
            currentDocument = new LoudTextDocument();
        }else {
            currentDocument = new TextDocument();
        }
        
        
        while(keepEditing) {
            String currentLine;
            System.out.println("\n\n\n\n\n\n");
            System.out.println(currentDocument);
            currentLine = keyboard.nextLine();
            //:exit, :undo, 
            if(currentLine.equals(":exit")) {
                keepEditing = false;
            }else if (currentLine.equals(":undo")) {
                currentDocument.undo();
            }else {
                currentDocument.addLine(currentLine);
            }
        }

    }

}
