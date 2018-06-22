package problem1_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        String[] truckInfo = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch (command[0].toLowerCase()){
                case "drive":
                    switch (command[1].toLowerCase()){
                        case "car":
                            try {
                                car.drive(Double.parseDouble(command[2]));
                            } catch (IllegalArgumentException ie){
                                System.out.println(ie.getMessage());
                            }
                            break;
                        case "truck":
                            try {
                                truck.drive(Double.parseDouble(command[2]));
                            } catch (IllegalArgumentException ie){
                                System.out.println(ie.getMessage());
                            }
                            break;
                    }
                    break;
                case "refuel":
                    switch (command[1].toLowerCase()){
                        case "car":
                            car.refuel(Double.parseDouble(command[2]));
                            break;
                        case "truck":
                            truck.refuel(Double.parseDouble(command[2]));
                            break;
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
