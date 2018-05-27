import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> names = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            names.add(reader.readLine());
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
