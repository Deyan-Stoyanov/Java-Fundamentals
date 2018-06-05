import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        Function<List<Integer>, Integer> findSmallestElement = (list) -> {
            int minElement = Integer.MAX_VALUE;
            int bestIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= minElement){
                    minElement = list.get(i);
                    bestIndex = i;
                }
            }
            return bestIndex;
        };
        System.out.println(findSmallestElement.apply(numbers));
    }
}
