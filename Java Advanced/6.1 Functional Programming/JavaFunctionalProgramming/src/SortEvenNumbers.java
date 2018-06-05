import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split("[,\\s]+")).map(Integer::parseInt).filter(x -> x % 2 == 0).collect(Collectors.toCollection(ArrayList::new));
        StringBuilder sb = new StringBuilder();
        nums.forEach(x -> sb.append(x).append(", "));
        if(!sb.toString().isEmpty()){
            sb.delete(sb.length() - 2, sb.length());
            sb.append(System.lineSeparator());
        }
        nums.stream().sorted(Integer::compareTo).forEach(x -> sb.append(x).append(", "));
        if(!sb.toString().isEmpty()){
            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }
    }
}
