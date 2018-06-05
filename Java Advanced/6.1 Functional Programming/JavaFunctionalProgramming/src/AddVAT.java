import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] prices = Arrays.stream(reader.readLine().split("[\\s,]+")).mapToDouble(Double::parseDouble).toArray();
        UnaryOperator<Double> addVAT = x -> x *= 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(prices).forEach(x -> System.out.println(String.format("%.2f", addVAT.apply(x))));
    }
}
