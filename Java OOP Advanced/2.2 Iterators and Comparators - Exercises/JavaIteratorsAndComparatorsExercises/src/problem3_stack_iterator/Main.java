package problem3_stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String command;
        while (!"END".equalsIgnoreCase(command = reader.readLine())){
            String[] tokens = command.split("[\\s,]+");
            switch (tokens[0]){
                case "Push":
                    Integer[] input = new Integer[tokens.length - 1];
                    for (int i = 1; i < tokens.length; i++) {
                        input[i - 1] = Integer.parseInt(tokens[i]);
                    }
                    stack.push(input);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    }catch (NoSuchElementException nse){
                        System.out.println(nse.getMessage());
                    }
                    break;
                    default:break;
            }
        }
        for (int i = 0; i < 2; i++) {
            stack.forEach(System.out::println);
        }
    }
}
