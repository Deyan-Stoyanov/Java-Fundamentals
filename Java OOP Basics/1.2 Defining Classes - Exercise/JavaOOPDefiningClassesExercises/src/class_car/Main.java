package class_car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            Car car = new Car(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
            if(!cars.containsKey(car.getModel())){
                cars.putIfAbsent(car.getModel(), car);
            }
        }
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String carModel = command.split(" ")[1];
            double drivingDistance = Double.parseDouble(command.split(" ")[2]);
            if(cars.containsKey(carModel)){
                try {
                    cars.get(carModel).drive(drivingDistance);
                } catch (IllegalArgumentException ie){
                    System.out.println(ie.getMessage());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        cars.forEach((key, value) -> sb.append(String.format("%s %.2f %.0f%n", value.getModel(), value.getFuelAmount(), value.getDistanceTravelled())));
        System.out.println(sb.toString());
    }
}
