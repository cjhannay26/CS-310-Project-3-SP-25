import  java.util.ArrayList;
import  java.util.List;

// Define function called intersect that takes in 2 lists
// Returns a list
public class Mason {
    public static <T> List<T> intersect(List<T> list1, List<T> list2) {
        // if list1 is null, return empty list
        if (list1 == null) {
            return new ArrayList<>();
        }

        List<T> result = new ArrayList<>();

        // Iterate through list 1
        for (T item : list1) {
            //if list 2 contains said element
            if (list2.contains(item)) {
                result.add(item); // add it to returned list
            }
        }

        // Return resulting list
        return result;
    }
}


// 