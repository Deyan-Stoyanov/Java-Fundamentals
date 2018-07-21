package problem3_coffee_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String line;
        while(!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            switch (tokens.length){
                case 1:
                    coffeeMachine.insertCoin(tokens[0]);
                    break;
                case 2:
                    coffeeMachine.buyCoffee(tokens[0], tokens[1]);
                    break;
                    default:break;
            }
        }
        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee.toString());
        }
    }
}