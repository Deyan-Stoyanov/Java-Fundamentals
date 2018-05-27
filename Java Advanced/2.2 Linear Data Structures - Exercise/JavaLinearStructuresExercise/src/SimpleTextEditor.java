import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<String> stack = new ArrayDeque<>();
        stack.push("");
        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch (Integer.parseInt(command[0])){
                case 1:
                    StringBuilder sb = new StringBuilder();
                    if(!stack.isEmpty()){
                        sb.append(stack.peek());
                    }
                    sb.append(command[1]);
                    stack.push(sb.toString());
                    break;
                case 2:
                    StringBuilder sb1 = new StringBuilder();
                    if(!stack.isEmpty()){
                        sb1.append(stack.peek());
                    }
                    sb1.delete(Math.max(0, (sb1.toString().length() - Integer.parseInt(command[1]))), sb1.toString().length());
                    stack.push(sb1.toString());
                    break;
                case 3:
                    if(!stack.isEmpty()){
                        String currentString = stack.peek();
                        if (currentString != null) {
                            char[] chars = currentString.toCharArray();
                            int index = Integer.parseInt(command[1]) - 1;
                            if(index >= 0 && index < chars.length){
                                System.out.println(currentString.toCharArray()[index]);
                            }
                        }
                    }
                    break;
                case 4:
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                    default:
                        break;
            }
        }
    }
}
