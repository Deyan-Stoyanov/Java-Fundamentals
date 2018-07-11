package problem5_generic_count_method_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            box.add(reader.readLine());
        }
        String comparator = reader.readLine();
        System.out.println(box.compare(comparator));
    }
}
