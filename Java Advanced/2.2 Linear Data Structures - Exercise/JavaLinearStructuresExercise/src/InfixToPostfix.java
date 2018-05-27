import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> stack = new ArrayDeque<>();
        Queue<String> outputQueue = new ArrayDeque<>();
        String[] expression = reader.readLine().split("\\s+");
        for (String s:expression) {
            if(s.matches("[0-9a-z]+")){
                outputQueue.add(s);
            } else if(s.matches("[+\\-*/^]")){
                stack.push(s);
            }
        }
        while (!stack.isEmpty()){
            outputQueue.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!outputQueue.isEmpty()){
            sb.append(outputQueue.remove()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
