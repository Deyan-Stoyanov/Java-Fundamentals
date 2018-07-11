package problem8_custom_list_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> myList = new MyList<>();
        String command;
        while (!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            switch (data[0]) {
                case "Add":
                    myList.add(data[1]);
                    break;
                case "Remove":
                    myList.remove(Integer.parseInt(data[1]));
                    break;
                case "Contains":
                    System.out.println(myList.contains(data[1]));
                    break;
                case "Swap":
                    myList.swap(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                    break;
                case "Greater":
                    System.out.println(myList.countGreaterThan(data[1]));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Sort":
                    myList.sort();
                    break;
                case "Print":
                    System.out.println(myList.toString());
                    break;
                default:
                    break;
            }
        }
    }
}
