
public class GraduateDriver {

    public static void main(String[] args) {
        Student grad1 = new GraduateStudent("GradStudent" , 555555L, new BasicDate(5,5,2000), "Law");
        
        Student ugrad1 = new Student("New Student", 11111L, new BasicDate(10,10,2005));
        
        CourseRoster course = new CourseRoster(1234);
        course.addStudent(grad1);
        course.addStudent(ugrad1);
        System.out.println(course);

        System.out.println(grad1);
        
        System.out.println(grad1.getClassStanding());

    }

}
