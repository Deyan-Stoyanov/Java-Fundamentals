import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        String firstString = String.format("%-10s", Integer.toHexString(a).toUpperCase());
        String secondString = String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0");
        String thirdString = String.format("%10s", String.format("%.2f", b));
        String fourthString = String.format("%-10s", String.format("%.3f", c));
        System.out.println("|" + firstString + "|" + secondString + "|" + thirdString + "|" + fourthString + "|");
    }
}
