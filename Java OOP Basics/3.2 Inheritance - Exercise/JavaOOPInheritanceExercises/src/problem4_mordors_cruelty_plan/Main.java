package problem4_mordors_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Gandalf gandalf = new Gandalf();
        String[] foods = reader.readLine().split("\\s+");
        for (String food : foods) {
            gandalf.eat(new Food(food));
        }
        System.out.println(gandalf);
    }
}
