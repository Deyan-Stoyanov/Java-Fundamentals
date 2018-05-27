import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] commands = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numbersToEnqueue = commands[0];
        int numbersToDequeue = commands[1];
        int searchedNumber = commands[2];
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numbersToEnqueue; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < numbersToDequeue; i++) {
            queue.remove();
        }
        if(queue.contains(searchedNumber)){
            System.out.println(true);
        } else {
            int lowestNumber = Integer.MAX_VALUE;
            if(queue.isEmpty()){
                lowestNumber = 0;
            }
            for (Integer i:queue) {
                if(i <= lowestNumber){
                    lowestNumber = i;
                }
            }
            System.out.println(lowestNumber);
        }
    }
}
