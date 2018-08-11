import java.util.List;

public class Bubble {
    public static <T extends Comparable<T>> void sort(List<T> t){
        for (int i = 0; i < t.size(); i++) {
            for (int j = 1; j < t.size(); j++) {
                if((t.get(j - 1).compareTo(t.get(j))) > 0){
                    T temp = t.get(j - 1);
                    t.set(j - 1, t.get(j));
                    t.set(j, temp);
                }
            }
        }
    }
}
