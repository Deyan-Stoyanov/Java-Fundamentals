package pizza_calories;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Topping {
    private static final String[] TOPPING_TYPES = new String[]{"Meat", "Veggies", "Cheese", "Sauce"};

    private String type;
    private double weight;
    private double totalCalories;

    public Topping() {
    }

    public Topping(String type, double weight) {
        this.setWeight(weight);
        this.setType(type);
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        if (!Arrays.stream(TOPPING_TYPES).collect(Collectors.toList()).contains(type)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    public double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.getType()));
        }
        this.weight = weight;
    }

    public double getTotalCalories() {
        this.setTotalCalories();
        return this.totalCalories;
    }

    private void setTotalCalories() {
        double totalCalories = this.getWeight() * 2D;
        switch (this.getType()) {
            case "Meat":
                totalCalories *= 1.2;
                break;
            case "Veggies":
                totalCalories *= 0.8;
                break;
            case "Cheese":
                totalCalories *= 1.1;
                break;
            case "Sauce":
                totalCalories *= 0.9;
                break;
            default:
                break;
        }
        this.totalCalories = totalCalories;
    }
}
