import java.util.Arrays;
import java.util.Comparator;

public class SortStrings {

    public static void main(String[] args) {
        String[] fruits = {"blueberry", "pear", "banana", "apple", "papaya", "kiwi"};
        
        Comparator<String> comparisonBox = new StringLengthComparator();
        Arrays.sort(fruits, comparisonBox);
        
        System.out.println(Arrays.toString(fruits));
    }

}
