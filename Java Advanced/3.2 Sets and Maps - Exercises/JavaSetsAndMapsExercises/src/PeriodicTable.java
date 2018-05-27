import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> table = new TreeSet<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] elements = reader.readLine().split("\\s+");
            table.addAll(Arrays.asList(elements));
        }
        System.out.println(table.toString().replaceAll("[\\,\\[\\]]", "").trim());
    }
}
