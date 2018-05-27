import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] commands = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numbersToPush = commands[0];
        int numbersToPop = commands[1];
        int searchedNumber = commands[2];
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numbersToPush; i++) {
            stack.push(nums[i]);
        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }
        if(stack.contains(searchedNumber)){
            System.out.println(true);
        } else {
            int bestNumber = Integer.MAX_VALUE;
            if(stack.isEmpty()){
                bestNumber = 0;
            }
            while(!stack.isEmpty()){
                int temp = stack.pop();
                if(temp < bestNumber){
                    bestNumber = temp;
                }
            }
            System.out.println(bestNumber);
        }
    }
}
