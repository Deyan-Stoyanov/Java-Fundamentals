package problem3_dependency_inversion;

import problem3_dependency_inversion.abstractions.Calculator;
import problem3_dependency_inversion.models.PrimitiveCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new PrimitiveCalculator();
        String command;
        while (!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "mode":
                    calculator.changeStrategy(tokens[1].charAt(0));
                    break;
                default:
                    try {
                        System.out.println(calculator.performCalculation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
                    } catch (UnsupportedOperationException uoe){
                        System.out.println(uoe.getMessage());
                    }
                    break;
            }
        }
    }
}
