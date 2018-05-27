import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, double[]> students = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            students.put(name, grades);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#############################");
        for (Map.Entry<String, double[]> entry : students.entrySet()) {
            double avg = 0;
            for (double grade:entry.getValue()) {
                avg += grade;
            }
            avg /= entry.getValue().length;
            System.out.println(entry.getKey() + " is graduated with " + avg);
        }
    }
}
