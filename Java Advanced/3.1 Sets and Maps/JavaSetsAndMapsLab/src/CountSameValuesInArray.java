import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountSameValuesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr =reader.readLine().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String number : arr) {
            if (!map.containsKey(number)) {
                map.put(number, 0);
            }
            map.put(number, map.get(number) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s - %d times%n", entry.getKey(), entry.getValue());
        }
    }
}
