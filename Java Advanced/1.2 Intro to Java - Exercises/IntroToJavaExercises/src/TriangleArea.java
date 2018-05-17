import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ax = scanner.nextDouble();
        double ay = scanner.nextDouble();
        scanner.nextLine();
        double bx = scanner.nextDouble();
        double by = scanner.nextDouble();
        scanner.nextLine();
        double cx = scanner.nextDouble();
        double cy = scanner.nextDouble();
        double area = ((ax * (by-cy)) + (bx *(cy-ay)) + (cx * (ay-by))) / 2;
        System.out.println(Math.abs(Math.round(area)));
    }
}
