package java_advanced_22_08_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> flowers = new ArrayDeque<>();
        Deque<Integer> buckets = new ArrayDeque<>();
        Queue<Integer> secondNature = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).forEach(flowers::offer);
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).forEach(buckets::push);
        while(!flowers.isEmpty() && !buckets.isEmpty()) {
            int bucket = buckets.poll();
            int flower = flowers.remove();
            if(bucket > flower){
                bucket -= flower;
                if(!buckets.isEmpty()){
                    int nextBucket = buckets.poll();
                    nextBucket += bucket;
                    buckets.push(nextBucket);
                } else {
                    buckets.push(bucket);
                }
            } else if (bucket < flower){
                flower -= bucket;
                ((ArrayDeque<Integer>) flowers).push(flower);
            } else {
                secondNature.offer(flower);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(flowers.isEmpty()){
            while(!buckets.isEmpty()) {
                sb.append(buckets.remove()).append(" ");
            }
            sb.append(System.lineSeparator());
        } else {
            while(!flowers.isEmpty()) {
                sb.append(flowers.remove()).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        if(secondNature.isEmpty()){
            sb.append("None");
        } else {
            while(!secondNature.isEmpty()) {
                sb.append(secondNature.remove()).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
