import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        if(firstName.isEmpty()){
            firstName = "*****";
        }
        System.out.printf("Hello, %s %s!%n", firstName, lastName);
    }
}
