package problem4_list_utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{
            add(1);
            add(2);
            add(18);
            add(2);
            add(-1);
        }};
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");
        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));
        System.out.println(ListUtils.getMin(strings));
        System.out.println(ListUtils.getMax(strings));
    }
}
