package problem7_generic_add_all_method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.5, 2.15, 65.2);
        List<Number> destination = new ArrayList<>();
        ListUtils.addAll(destination, doubles);
        System.out.println(destination);
    }
}
