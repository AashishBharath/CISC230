
public class GradeDriver {

    public static void main(String[] args) {
        //String myGrade = "B+";
        //LetterGrade myGrade = new LetterGrade(3.3, "B+");
        LetterGrade myGrade = LetterGrade.B_PLUS;
        LetterGrade myGrade2 = LetterGrade.A;
        System.out.println("The grade is " + myGrade+ " worth "+myGrade.getQualityPoints());
        
        //Can now use double == to compare objects when objects are final.
        if(myGrade != myGrade2) {
            System.out.println("Hello");
        }
        
        Grade myGrade3 = Grade.A;
        System.out.println("My grade is " + myGrade3 +" worth " + myGrade3.getQualityPoints());
    }

}
