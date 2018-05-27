import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new TreeMap<>();
        char[] input = reader.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if(!map.containsKey(input[i])){
                map.put(input[i], 0);
            }
            map.put(input[i], map.get(input[i]) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey().toString(), entry.getValue());
        }
    }
}
