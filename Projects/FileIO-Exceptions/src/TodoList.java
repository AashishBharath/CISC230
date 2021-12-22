import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The TodoList class controls the user's whole list.
 * It will build a whole TodoList from scratch regardless if the file exists or not. 
 * The TodoList may be displayed in order of Date or Importance. 
 * The TodoList must also be finalized in order to save the file to the computer.   
 * @author Aashish Bharath 
 *
 */
public class TodoList {
    /**Private Arraylist that holds the individual TodoItems aka the "tasks" of the TodoList */
    private ArrayList<TodoItem> theTasks;
    
    /**The username that user inputs . . .represents the name of file in question */
    private String username;
    
    /**
     * The constructor initializes theTasks to a new ArrayList of TodoItems.
     * username is initialized as the String that the user inputs.
     * 
     * @param username name of the file user wishes to open or create. 
     */
    public TodoList(String username) {
        theTasks = new ArrayList<TodoItem>();
        this.username = username;
        
    }
    
    /**
     * Static factory method that can be called to create a TodoList.
     * This is only used when the file exists prior to the user starting program. 
     * Catches any issues with opening file, and reading file. 
     * 
     * Method reads through file, and for every line in the file a new TodoItem is created. 
     * Each TodoItem is then added to the specific TodoLists's theTasks.
     * 
     * 
     * @param name username that the user wants to open a file with. 
     * @return TodoList 
     */
    public static TodoList buildFromUsername(String name) {
        TodoList newTodoList = new TodoList(name);
        List<String> theLines;
        TodoItem newTask;
        //ArrayList<TodoItem> tasks = new ArrayList<TodoItem>();
        
        try {
            theLines = Files.readAllLines(Paths.get(name+".txt"), StandardCharsets.UTF_8);
        } catch(IOException e) {
            throw new IllegalArgumentException();
        }
        
        //Populates a newTodoList's theTasks with TodoItems from the existing file. 
        for(String currentLine : theLines) {
            try {
                newTask = TodoItem.buildFromCSV(currentLine);
            }catch(IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
            newTodoList.addTask(newTask);
        }
        
        
        return newTodoList;
        
        
    }
    
    /**
     * Adds a TodoItem to theTasks ArrayList.
     * 
     * @param task TodoItem that needs to be added to theTasks
     */
    public void addTask(TodoItem task) {
        theTasks.add(task);
    }
    
    /**
     * theTasks are sorted based on date and returned in that order in String format.
     * The actual order of theTasks is not changed.
     * Uses Array.sort() method which uses DateComparator 
     * 
     * @return String sortedTodoList theTasks sorted according to date. 
     */
    public String getAsDateSortedString() {
        String sortedTodoList = "";
        ArrayList<TodoItem> tasksHolder = new ArrayList<TodoItem>();
        Date[] dates = new Date[theTasks.size()];
        Comparator<Date> comparisonBox = new DateComparator();
        
        //Populates a temporary holder for tasks in theTasks
        for(int i = 0; i<theTasks.size();i++) {
            tasksHolder.add(theTasks.get(i));
        }
       
        
        //Populate dates with all dates in the given To do list
        for(int i = 0; i< theTasks.size(); i++) {
            dates[i] = theTasks.get(i).getDate();
        }
        //Sorts dates array
        Arrays.sort(dates, comparisonBox);
        
        for(int i = 0; i<dates.length;i++) {
            for(int j = 0; j<theTasks.size();j++) {
                if(theTasks.get(j).getDate().compareTo(dates[i]) == 0) {
                    sortedTodoList = sortedTodoList + theTasks.get(j);
                    //Removing item from theTasks so that repeats are avoided. 
                    theTasks.remove(j);
                }
            }
            
        }
        
        //Re-populates theTasks
        for(int i = 0;i<tasksHolder.size();i++) {
            theTasks.add(tasksHolder.get(i));
        }
        
        return sortedTodoList;
        
    }
    /**
     * theTasks are sorted based on Importance and returned in that order in String format.
     * The actual order of theTasks is not changed.
     * Uses Array.sort() method which uses ImportanceComparator 

     * @return String sortedTodoList theTasks sorted according to importance. 
     */
    public String getAsImportanceSortedString() {
        String sortedTodoList = "";
        ArrayList<TodoItem> tasksHolder = new ArrayList<TodoItem>();

        Importance[] importanceLevels = new Importance[theTasks.size()];
        Comparator<Importance> comparisonBoxImportance = new ImportanceComparator();
        
        //Populates a temporary holder for tasks in theTasks
        for(int i = 0; i<theTasks.size();i++) {
            tasksHolder.add(theTasks.get(i));
        }
        
        //Populate importanceLevel with all importance levels in the given To do list
        for(int i = 0; i< theTasks.size(); i++) {
            importanceLevels[i] = theTasks.get(i).getImportanceLevel();
            
        }
        //Sorts importanceLevels array
        Arrays.sort(importanceLevels, comparisonBoxImportance);
        
        
        
        for(int i = 0; i<importanceLevels.length;i++) {
            //System.out.println(importanceLevels[i]);
            for(int j = 0; j<theTasks.size();j++) {
                if(theTasks.get(j).getImportanceLevel().equals(importanceLevels[i])) {
                        sortedTodoList = sortedTodoList + theTasks.get(j);
                        //Removing item from theTasks so that repeats are avoided. 
                        theTasks.remove(j);
                }
            }
        }
        
        //Re-populates theTasks
        for(int i = 0;i<tasksHolder.size();i++) {
            theTasks.add(tasksHolder.get(i));
        }
        
        return sortedTodoList;
    }
    
    /**
     *Writes theTasks to the file with username.txt
     *converts each TodoItem to a CSV, compiling every TodoItem on their own line and into one String, toWrite
     *
     *Then toWrite is written to the file.
     *
     *Catches any IOExceptions while trying to write to file. 
     */
    public void finalize() {
        //files.write()
        String toWrite = "";
        for(TodoItem currentItem : theTasks) {
            toWrite = toWrite + currentItem.getAsCSV() + "\n";
        }
        try {
            //Creates new file called Short.txt
            //Inputs the string toWrite into the file
            Files.write(Paths.get(username+ ".txt"), toWrite.getBytes(StandardCharsets.UTF_8));
        } catch(IOException e) {
            System.out.println("Problem writing file");
            return;
        }
    }
    
    

}
