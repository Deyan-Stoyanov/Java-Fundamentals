import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.math.BigDecimal;
        import java.util.Arrays;

public class ProductsOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        BigDecimal result = BigDecimal.ONE;
        int currentNumber = nums[0];
        do {
            result = result.multiply(BigDecimal.valueOf(currentNumber));
            currentNumber++;
        }while(currentNumber <= nums[1]);
        System.out.printf("product[%d..%d] = %.0f", nums[0], nums[1], result);
    }
}
