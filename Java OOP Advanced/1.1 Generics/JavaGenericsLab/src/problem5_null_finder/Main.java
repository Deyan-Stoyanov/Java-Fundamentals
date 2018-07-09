package problem5_null_finder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{
            add(1);
            add(2);
            add(null);
            add(2);
            add(null);
        }};
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", null, "c");
        List<Integer> integerNulls = ListUtils.getNullIndices(integers);
        List<Integer> stringNulls = ListUtils.getNullIndices(strings);
        System.out.println(integerNulls);
        System.out.println(stringNulls);
    }
}
