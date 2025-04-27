import java.util.List;
import java.util.ArrayList;

public class Gracie {
    public static boolean member(Object var, List<?> lizt) {
            if (lizt == null || lizt.isEmpty()) {
                return false;
            }
            if (var.equals(lizt.get(0))) {
                return true;
            }
            return member(var, lizt.subList(1, lizt.size()));
    }

    public static List<Object> append (List <?> lizt1, List <?> lizt2){
        if (lizt1 == null || lizt1.isEmpty()) {
            return new ArrayList<>(lizt2);
        }
        List<Object> result = new ArrayList<>();
        result.add(lizt1.get(0));
        result.addAll(append(lizt1.subList(1, lizt1.size()), lizt2));
        return result;
    }
}