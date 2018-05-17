import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclePark {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> vehicles = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String line = reader.readLine();
        Integer carsSold = 0;
        while (!"End of customers!".equals(line)) {
            String neededCar = line.split("\\s+")[0].substring(0, 1);
            Integer neededSeats = Integer.parseInt(line.split("\\s+")[2]);
            Boolean carFound = false;
            for (String s : vehicles) {
                String car = s.substring(0, 1);
                Integer seats = Integer.parseInt(s.substring(1));
                if (neededCar.toLowerCase().equals(car.toLowerCase()) && neededSeats.equals(seats)) {
                    Integer price = car.toCharArray()[0] * seats;
                    System.out.printf("Yes, sold for %s$%n", price);
                    carFound = true;
                    carsSold++;
                    vehicles.remove(s);
                    break;
                }
            }
            if (!carFound) {
                System.out.println("No");
            }
            line = reader.readLine();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles left: ");
        for (String s:vehicles) {
            sb.append(s).append(", ");
        }
        String vehiclesLeft = sb.toString();
        if(sb.toString().lastIndexOf(',') != -1){
            vehiclesLeft = sb.toString().substring(0, sb.toString().lastIndexOf(','));
        }
        System.out.println(vehiclesLeft);
        System.out.printf("Vehicles sold: %d", carsSold);
    }
}
