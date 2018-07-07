package exam_preparation_2.entities.garage;

import exam_preparation_2.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    private void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void parkCar(Car car){
        if(!this.parkedCars.contains(car)) {
            this.parkedCars.add(car);
        }
    }

    public void unparkCar(Car car){
        this.parkedCars.remove(car);
    }
}
