import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        char[] expression = input.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length; i++) {
            if(expression[i] == '('){
                stack.push(i);
            } else if(expression[i] == ')'){
                String subexpression = input.substring(stack.pop(), i + 1);
                System.out.println(subexpression);
            }
        }
    }
}
