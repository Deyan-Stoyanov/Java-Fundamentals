package problem2_vehicle_extensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        String[] truckInfo = reader.readLine().split("\\s+");
        String[] busInfo = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch (command[1].toLowerCase()) {
                case "car":
                    executeCommand(car, command);
                    break;
                case "truck":
                    executeCommand(truck, command);
                    break;
                case "bus":
                    switch (command[0].toLowerCase()) {
                        case "drive":
                            try {
                                bus.drive(Double.parseDouble(command[2]));
                            } catch (IllegalArgumentException ie) {
                                System.out.println(ie.getMessage());
                            }
                            break;
                        case "driveempty":
                            try {
                                ((Bus) bus).driveEmpty(Double.parseDouble(command[2]));
                            } catch (IllegalArgumentException ie) {
                                System.out.println(ie.getMessage());
                            }
                            break;
                        case "refuel":
                            try {
                                bus.refuel(Double.parseDouble(command[2]));
                            } catch (IllegalArgumentException ie) {
                                System.out.println(ie.getMessage());
                            }
                            break;
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void executeCommand(Vehicle truck, String[] command) {
        switch (command[0].toLowerCase()) {
            case "drive":
                try {
                    truck.drive(Double.parseDouble(command[2]));
                } catch (IllegalArgumentException ie) {
                    System.out.println(ie.getMessage());
                }
                break;
            case "refuel":
                try {
                    truck.refuel(Double.parseDouble(command[2]));
                } catch (IllegalArgumentException ie) {
                    System.out.println(ie.getMessage());
                }
                break;
        }
    }
}

