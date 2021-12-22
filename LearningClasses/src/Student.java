
public class Student {
	private String name;
	private long id;
	private BasicDate birthdate;
	private int creditsCompleted;
	private boolean currentlyActive;
	
	//Constructors
	
	//Brand new student
	public Student(String name, long id, BasicDate birthdate) {
			this.name = name;
			this.id = id;
			this.birthdate = birthdate;
			this.creditsCompleted = 0;
			this.currentlyActive = true;
		}
		
	//Current or former student
	public Student(String name, long id, BasicDate birthdate, int credits, boolean active) {
		this.name = name;
		this.id = id;
		this.birthdate = birthdate;
		this.creditsCompleted = credits;
		this.currentlyActive = active;
		
	}
	
	
	
	
	
	
	//Methods
	public boolean isSameStudent(Student other) {
		//compare this to other
		if(this.id == other.id) {
			return true;
		}
		return false;
		
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
	    return name;
	}
	
	public ClassStanding getClassStanding() {
		if(creditsCompleted<28) {
			return ClassStanding.FRESHMAN;
		}else if(creditsCompleted<60) {
			return ClassStanding.SOPHOMORE;
		}else if(creditsCompleted<92) {
			return ClassStanding.JUNIOR;
		}else {
			return ClassStanding.SENIOR;
		}
	}
	
	@Override
	public String toString() {
		//return name +":" + id + ":" + birthdate + ":" +creditsCompleted + ":" + currentlyActive; 
		return name + "("+ id +")";
	}

}
