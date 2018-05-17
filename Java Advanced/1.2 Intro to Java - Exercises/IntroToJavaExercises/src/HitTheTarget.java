import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitTheTarget {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if(i + j == target){
                    System.out.printf("%d + %d = %d%n", i, j, target);
                } else if(i - j == target){
                    System.out.printf("%d - %d = %d%n", i, j, target);
                }
            }
        }
    }
}
