
public class BirthInfoDriver {

    public static void main(String[] args) {
        BirthInformation2 aBirth = new BirthInformation2(2,28,2009, "St. Paul, MN");
        
        System.out.println(aBirth);
        System.out.println(aBirth.toYYMMDD());

    }

}
