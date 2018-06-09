package java_advanced_03_01_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> numbers = new LinkedList<>();
        for (int i : nums) {
            numbers.offer(i);
        }
        nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> integers = new LinkedList<>();
        for (int i : nums) {
            integers.offer(i);
        }
        Queue<Integer> result = new LinkedList<>();
        while(result.size() < 6) {
            int firstNumber = numbers.peek();
            int firstInteger = integers.remove();
            if(firstInteger % firstNumber == 0){
                result.offer(firstInteger);
                numbers.remove();
            } else {
                integers.offer(++firstInteger);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i).append(", ");
        }
        System.out.println(sb.subSequence(0, sb.length() - 2).toString());
    }
}
