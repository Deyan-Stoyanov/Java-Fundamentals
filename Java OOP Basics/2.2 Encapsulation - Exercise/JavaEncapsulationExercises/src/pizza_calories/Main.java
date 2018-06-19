package pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaInput = reader.readLine().split("\\s+");
        String[] doughInput = reader.readLine().split("\\s+");
        try {
            Pizza pizza = getPizza(pizzaInput);
            if (pizza != null) {
                addDough(pizza, doughInput);
                addToppings(pizza, reader, pizzaInput);
                System.out.println(pizza);
            }
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
    }

    private static Pizza getPizza(String[] pizzaInput) {
        Pizza pizza = null;
        pizza = new Pizza(pizzaInput[1], Integer.parseInt(pizzaInput[2]));
        return pizza;
    }

    private static void addToppings(Pizza pizza, BufferedReader reader, String[] pizzaInput) throws IOException {
        for (int i = 0; i < Integer.parseInt(pizzaInput[2]); i++) {
            String command = reader.readLine();
            Topping topping = new Topping(command.split("\\s+")[1], Double.parseDouble(command.split("\\s+")[2]));
            pizza.addToToppings(topping);
        }
    }

    private static void addDough(Pizza pizza, String[] doughInput) {
        Dough dough;
        dough = new Dough(doughInput[1], doughInput[2], Double.parseDouble(doughInput[3]));
        pizza.setDough(dough);
    }
}
