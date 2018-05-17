import java.util.Scanner;

public class AverageOfThreeNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double firstDouble = Double.parseDouble(scanner.next());
        Double secondDouble = Double.parseDouble(scanner.next());
        Double thirdDouble =  Double.parseDouble(scanner.next());
        Double average = (firstDouble+secondDouble+thirdDouble) / 3D;
        System.out.printf("%.2f%n", average);
    }
}
