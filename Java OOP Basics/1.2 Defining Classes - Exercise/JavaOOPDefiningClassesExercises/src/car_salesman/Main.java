package car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        addEngines(reader, engines, n);
        n = Integer.parseInt(reader.readLine());
        addCars(reader, engines, cars, n);
        cars.forEach(System.out::println);
    }

    private static void addCars(BufferedReader reader, List<Engine> engines, List<Car> cars, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] carInput = reader.readLine().split("\\s+");
            String model = carInput[0];
            String engineName = carInput[1];
            Car car = new Car(model, engines.stream().filter(x -> x.getModel().equals(engineName)).findFirst().get());
            if (carInput.length == 3) {
                if (carInput[2].matches("[\\-+]?[0-9]+")) {
                    car.setWeight(Integer.parseInt(carInput[2]));
                } else {
                    car.setColor(carInput[2]);
                }
            }
            if (carInput.length == 4) {
                car.setWeight(Integer.parseInt(carInput[2]));
                car.setColor(carInput[3]);
            }
            cars.add(car);
        }
    }

    private static void addEngines(BufferedReader reader, List<Engine> engines, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] engineInput = reader.readLine().split("\\s+");
            String model = engineInput[0];
            int power = Integer.parseInt(engineInput[1]);
            Engine engine = new Engine(model, power);
            if (engineInput.length == 3) {
                if (engineInput[2].matches("[\\-+]?[0-9]+")) {
                    engine.setDisplacement(Integer.parseInt(engineInput[2]));
                } else {
                    engine.setEfficiency(engineInput[2]);
                }
            }
            if (engineInput.length == 4) {
                engine.setDisplacement(Integer.parseInt(engineInput[2]));
                engine.setEfficiency(engineInput[3]);
            }
            engines.add(engine);
        }
    }
}
