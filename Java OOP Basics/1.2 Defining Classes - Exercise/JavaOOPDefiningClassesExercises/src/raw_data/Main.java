package raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Car> cars = new LinkedHashSet<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            Car car = new Car(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), input[4], Double.parseDouble(input[5]), Integer.parseInt(input[6]), Double.parseDouble(input[7]), Integer.parseInt(input[8]), Double.parseDouble(input[9]), Integer.parseInt(input[10]), Double.parseDouble(input[11]), Integer.parseInt(input[12]));
            cars.add(car);
        }
        String command = reader.readLine();
        StringBuilder sb = new StringBuilder();
        switch (command){
            case "fragile":
                cars.stream()
                        .filter(x -> x.getCargo().getType().equalsIgnoreCase(command) && x.getTires().stream().anyMatch(y -> y.getPressure() < 1))
                        .forEach(x -> sb.append(x.getModel()).append(System.lineSeparator()));
                break;
            case "flamable":
                cars.stream()
                .filter(x -> x.getCargo().getType().equalsIgnoreCase(command) && x.getEngine().getPower() > 250).forEach(x -> sb.append(x.getModel()).append(System.lineSeparator()));
                break;
        }
        System.out.println(sb.toString());
    }
}
