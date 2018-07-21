package problem9_linked_list_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> linkedList = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            Integer number = Integer.parseInt(tokens[1]);
            switch (command){
                case "Add":
                    linkedList.add(number);
                    break;
                case "Remove":
                    try {
                        linkedList.remove(number);
                    }catch (UnsupportedOperationException ignored){}
                    break;
                    default:break;
            }
        }
        System.out.println(linkedList.getSize());
        StringBuilder sb = new StringBuilder();
        for (Integer integer : linkedList) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}
