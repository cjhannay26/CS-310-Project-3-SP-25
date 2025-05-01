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
        // (memq (car lizt1) list2)
        //     (cons (car lizt1) (intersect (cdr lizt1) lizt2))

        else // return intersect passed cdr of list
        {
            return null; // stub
        }
    }
}


// 