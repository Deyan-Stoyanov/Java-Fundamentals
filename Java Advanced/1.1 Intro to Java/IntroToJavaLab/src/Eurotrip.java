import java.math.BigDecimal;
import java.util.Scanner;

public class Eurotrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal wurst = new BigDecimal(scanner.next());
        BigDecimal deutscheMark = (wurst.multiply(BigDecimal.valueOf(1.2))).multiply(BigDecimal.valueOf(4210500000000L));
        System.out.printf("%.2f marks%n", deutscheMark);
    }
}
