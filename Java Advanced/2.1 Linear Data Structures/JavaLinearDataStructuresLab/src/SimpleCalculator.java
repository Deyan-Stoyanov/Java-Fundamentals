import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String[] input = reader.readLine().split("\\s+");
        Deque<String> stack = new ArrayDeque<>(Arrays.asList(input));
        result = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()){
            String temp = stack.pop();
            if(temp.equalsIgnoreCase("+")){
                result += Integer.parseInt(stack.pop());
            } else if(temp.equalsIgnoreCase("-")){
                result -= Integer.parseInt(stack.pop());
            }
        }
        System.out.println(result);
    }
}
