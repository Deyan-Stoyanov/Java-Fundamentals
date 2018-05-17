import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddAndEvenPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if((numbers.length % 2) == 0){
            for (int i = 0; i < numbers.length - 1; i+=2) {
                if(numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0){
                    System.out.printf("%d, %d -> both are even%n", numbers[i], numbers[i + 1]);
                } else if(numbers[i] % 2 != 0 && numbers[i + 1] % 2 != 0){
                    System.out.printf("%d, %d -> both are odd%n", numbers[i], numbers[i + 1]);
                } else {
                    System.out.printf("%d, %d -> different%n", numbers[i], numbers[i + 1]);
                }
            }
        } else {
            System.out.println("invalid length");
        }
    }
}
