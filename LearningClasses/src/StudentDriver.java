public class StudentDriver {

    public static void main(String[] args) {
        // if you don't write a constructor, you get a no-arg one for free
        //Student student1 = new Student();
        // as soon as you write your own constructor, you lose the free no-arg one
        Student student1 = new Student("Student One", 9999999999L, new BasicDate(8,1,2002), 50, true);
        Student student2 = new Student("Student 1", 9999999999L, new BasicDate(8,1,2002), 60, true);
        Student student3 = new Student("New Student", 8888888888L, new BasicDate(10,10,2004));
        
        //System.out.println(student1);
        
        //System.out.println(student1.isSameStudent(student2));
        
        //System.out.println(student3);
        
        //System.out.println(student1.getClassStanding());
        //System.out.println(student2.getClassStanding());
        
        
        CourseRoster myCourse = new CourseRoster(12345);
        
        //myCourse.addStudent(student1);
        //myCourse.addStudent(student3);
        
        for (int i = 1; i <= 10; i++) {
            // loop to add 10 students to course roster
            // student 1 will have 45 credts, student 2 50, etc.
            myCourse.addStudent(new Student("Student "+i, 123456+i, new BasicDate(8, i, 2003), 40+5*i, true));
        }
        
        System.out.println(myCourse);
        
        // remove student with ID 123461
        myCourse.removeStudentById(123461L);
        System.out.println("After a removal...");
        System.out.println(myCourse);
        System.out.println(myCourse.findStudentByName("Student 4"));

        
        System.out.println("Print out sophomores...");
        System.out.println(myCourse.getByClassStanding("Sophomore"));
        

    }

}