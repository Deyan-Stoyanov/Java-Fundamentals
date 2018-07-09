package problem5_null_finder;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T> {

    public ListUtils() {
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list.");
        }
        T min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).compareTo(min) < 0){
                min = list.get(i);
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list.");
        }
        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).compareTo(max) > 0){
                max = list.get(i);
            }
        }
        return max;
    }

    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == null){
                result.add(i);
            }
        }
        return result;
    }
}
