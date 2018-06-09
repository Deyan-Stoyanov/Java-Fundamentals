package exam_preparation_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Examprep2Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Queue<Integer>> queues = new ArrayDeque<>();
        Queue<Integer> result = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Queue<Integer> tempQueue = new ArrayDeque<>();
            Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(tempQueue::offer);
            queues.offer(tempQueue);
        }
        while(!queues.isEmpty()) {
            Queue<Integer> temp = queues.remove();
            int integer = temp.remove();
            while(!temp.isEmpty()) {
                if(integer >= temp.peek()){
                    temp.remove();
                } else {
                    result.offer(integer);
                    break;
                }
            }
            if(temp.isEmpty()){
                result.offer(integer);
            } else {
                temp.offer(integer);
                queues.offer(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append(System.lineSeparator());
        while(!result.isEmpty()) {
            sb.append(result.remove()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
