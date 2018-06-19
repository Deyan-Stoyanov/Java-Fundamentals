package pizza_calories;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Dough {
    private final static String[] MAIN_TYPES = new String[]{"White", "Wholegrain"};
    private final static String[] ADDITIONAL_TYPES = new String[]{"Crispy", "Chewy", "Homemade"};

    private String mainType;
    private String additionalType;
    private double weight;
    private double totalCalories;

    public Dough() {
    }

    public Dough(String mainType, String additionalType, double weight) {
        this.setMainType(mainType);
        this.setAdditionalType(additionalType);
        this.setWeight(weight);
    }

    public String getMainType() {
        return mainType;
    }

    private void setMainType(String mainType) {
        if (!Arrays.stream(MAIN_TYPES).collect(Collectors.toList()).contains(mainType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.mainType = mainType;
    }

    public String getAdditionalType() {
        return additionalType;
    }

    private void setAdditionalType(String additionalType) {
        if (!Arrays.stream(ADDITIONAL_TYPES).collect(Collectors.toList()).contains(additionalType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.additionalType = additionalType;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }


    public double getTotalCalories() {
        this.setTotalCalories();
        return this.totalCalories;
    }

    private void setTotalCalories() {
        double totalCalories = this.weight * 2D;
        switch (this.getMainType()) {
            case "White":
                totalCalories *= 1.5;
                break;
            case "Wholegrain":
                totalCalories *= 1.0;
                break;
            default:
                break;
        }
        switch (this.getAdditionalType()) {
            case "Crispy":
                totalCalories *= 0.9;
                break;
            case "Chewy":
                totalCalories *= 1.1;
                break;
            case "Homemade":
                totalCalories *= 1.0;
                break;
            default:
                break;
        }
        this.totalCalories = totalCalories;
    }
}
