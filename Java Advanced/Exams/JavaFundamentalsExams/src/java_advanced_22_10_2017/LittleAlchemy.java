package java_advanced_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> table = new LinkedList<>();
        Deque<Integer> storage = new LinkedList<>();
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(table::offer);
        String command;
        while(!"Revision".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(input[0]).append(input[1]);
            if(sb.toString().equalsIgnoreCase("Applyacid")){
                int n = Integer.parseInt(input[2]);
                for (int i = 0; i < n; i++) {
                    if(!table.isEmpty()){
                        int number = table.remove() - 1;
                        if(number > 0){
                            table.offer(number);
                        } else {
                            storage.push(number);
                        }
                    }
                }
            } else if (sb.toString().equalsIgnoreCase("Airleak")){
                int m = Integer.parseInt(input[2]);
                if(!storage.isEmpty()){
                    storage.pop();
                    table.offer(m);
                }
            }
        }
        StringBuilder stones = new StringBuilder();
        while(!table.isEmpty()) {
            stones.append(table.remove()).append(" ");
        }
        stones.append(System.lineSeparator()).append(storage.size());
        System.out.println(stones.toString());
    }
}
