package java_advanced_19_02_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Queue<Integer>> nestedQueue = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> result = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Queue<Integer> temp = new ArrayDeque<>();
            for (int num : nums) {
                temp.offer(num);
            }
            nestedQueue.offer(temp);
        }
        while (!nestedQueue.isEmpty()) {
            Queue<Integer> queue = nestedQueue.remove();
            int seismicity = queue.remove();
            while (!queue.isEmpty()) {
                if (seismicity >= queue.peek()) {
                    queue.remove();
                } else {
                    result.offer(seismicity);
                    break;
                }
            }
            if(queue.isEmpty()){
                result.offer(seismicity);
            }
            if (!queue.isEmpty()) {
                nestedQueue.offer(queue);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append(System.lineSeparator());
        while (!result.isEmpty()) {
            sb.append(result.remove()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
