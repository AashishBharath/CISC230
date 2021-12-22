
public class GraduateStudent extends Student {
    
    //Student is super class
    // all of student is copied and pasted, but is invisible
    
    
    // new and different
    
    //instance variables
    
    private boolean thesisOption;
    private String graduateProgram;
    
    
    //constructors
    public GraduateStudent(String name, long id, BasicDate birthdate, String program) {
        //Must call super class constructor first! 
        super(name, id, birthdate);
        
        graduateProgram = program;
        thesisOption = false;
    }
    
    
    
    //methods
    public boolean isThesisOption() {
        return thesisOption;
    }
    
    public String getGraduateProgram() {
        return graduateProgram; 
    }
    
    @Override
    public ClassStanding getClassStanding() {
        return ClassStanding.GRADUATE_STUDENT;
    }
    
    @Override
    public String toString() {
        return super.toString() + " G";
    }
}
