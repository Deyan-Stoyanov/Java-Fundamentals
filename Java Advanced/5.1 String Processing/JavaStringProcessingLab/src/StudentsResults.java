import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentsResults {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] studentData = reader.readLine().split("[,\\-\\s+]+");
        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        double average = (Double.parseDouble(studentData[1]) +  Double.parseDouble(studentData[2]) + Double.parseDouble(studentData[3])) / 3;
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|%n", studentData[0], Double.parseDouble(studentData[1]), Double.parseDouble(studentData[2]), Double.parseDouble(studentData[3]), average);
    }
}
