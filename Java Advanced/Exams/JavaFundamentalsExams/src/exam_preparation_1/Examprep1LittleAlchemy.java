package exam_preparation_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Examprep1LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> table = new ArrayDeque<>();
        Queue<Integer> storage = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(table::offer);
        String command;
        while(!"Revision".equalsIgnoreCase(command = reader.readLine())) {
            int n = Integer.parseInt(command.substring(command.lastIndexOf(" ") + 1).trim());
            switch (command.substring(0, command.lastIndexOf(" ")).trim()){
                case "Apply acid":
                    for (int i = 0; i < n; i++) {
                        if(!table.isEmpty()){
                            int stone = table.remove();
                            if(--stone == 0){
                                storage.offer(stone);
                            } else {
                                table.offer(stone);
                            }
                        }
                    }
                    break;
                case "Air leak":
                    if(!storage.isEmpty()){
                        storage.remove();
                        table.offer(n);
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : table) {
            sb.append(i).append(" ");
        }
        sb.append(System.lineSeparator()).append(storage.size());
        System.out.println(sb.toString());
    }
}
