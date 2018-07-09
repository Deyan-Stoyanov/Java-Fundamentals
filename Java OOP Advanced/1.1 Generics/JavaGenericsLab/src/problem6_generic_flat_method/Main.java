package problem6_generic_flat_method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(2);
            add(15);
        }};
        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.5, 2.15, 65.2);
        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, integers, doubles);
        List<Number> destination = new ArrayList<>();
        ListUtils.flatten(destination, jagged);
        System.out.println(destination);
    }
}
