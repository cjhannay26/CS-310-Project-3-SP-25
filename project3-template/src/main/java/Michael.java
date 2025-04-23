import java.util.*;
import java.util.function.Function;

public class Michael {
    public static <T, R> List<R> map(Function<T, R> fun, List<T> list) {
        if (list.isEmpty()) {
            return new ArrayList<R>();
        } else {
            List<R> returnVar = new ArrayList<R>();
            for (T member : list) {
                returnVar.add(fun.apply(member));
            }
            return returnVar;
        }
    }

    public static <T, R> boolean same(List<R> list1, List<T> list2) {
        return list1.equals(list2);
    }
}