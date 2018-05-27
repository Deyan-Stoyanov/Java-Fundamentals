import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        String command;
        while (!"END".equalsIgnoreCase(command = reader.readLine())){
            String[] input = command.split(",\\s+");
            switch (input[0].toUpperCase()){
                case "IN":
                    set.add(input[1]);
                    break;
                case "OUT":
                    set.remove(input[1]);
                    break;
                    default:
                        break;
            }
        }
        if(set.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : set) {
                System.out.println(s);
            }
        }
    }
}
