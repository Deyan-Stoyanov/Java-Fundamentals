package exam_preparation_2.entities.cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceCar extends Car{

    private List<String> addOns;
    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, (horsepower + ((50 * horsepower) / 100)), acceleration,  (suspension - ((25 * suspension) / 100)), durability);
        this.addOns = new ArrayList<>();
    }

    public List<String> getAddOns() {
        return Collections.unmodifiableList(this.addOns);
    }

    private void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String addOns = this.getAddOns().size() == 0 ? "None" : String.join(", ", this.getAddOns());
        sb.append(super.toString()).append(String.format("%nAdd-ons: %s", addOns));
        return sb.toString();
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        super.tune(tuneIndex, addOn);
        this.addOns.add(addOn);
    }
}
