import java.util.ArrayList;

public class CourseRoster {
	
	private ArrayList<Student> theStudents;
	private int courseId;
	
	public CourseRoster(int courseId) {
		this.courseId = courseId;
		theStudents = new ArrayList<Student>();
	}
	
	public void addStudent(Student student) {
		theStudents.add(student);
	}
	

	
	public String toString() {
		String studentString = "";
		for(int i = 0; i<theStudents.size();i++) {
			Student currentStudent = theStudents.get(i);
			studentString = studentString + currentStudent.toString() +"\n";
		}
		return studentString;
	}
	
	
	public ArrayList<Student> getByClassStanding(String standing){
		ArrayList<Student> matchingStudents = new ArrayList <Student>();
		
		for(int i = 0; i< theStudents.size(); i++) {
			Student currentStudent = theStudents.get(i);
			if(currentStudent.getClassStanding().equals(standing)) {
				matchingStudents.add(currentStudent);
			}
		}
		return matchingStudents;
	}
	
	
	
	public boolean removeStudentById(long id) {
		int positionWhereFound = -1;
		for(int i = 0; i<theStudents.size(); i++) {
			Student currentStudent = theStudents.get(i);
			if(currentStudent.getId() == id) {
				positionWhereFound = i;
			}
		}
		if(positionWhereFound == -1) {
			return false;
		}else {
			theStudents.remove(positionWhereFound);
			return true;
		}
	}
	
	public int getCourseSize() {
		return theStudents.size();
	}
	
	public boolean findStudentByName(String name) {
		for(int i = 0; i< theStudents.size(); i++) {
			Student currentStudent = theStudents.get(i);
			if(currentStudent.getName().equals(name)) {
				return true;
			}
			
		
	}
		return false;

}
}
