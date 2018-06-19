package pizza_calories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private int numberOfToppings;
    private List<Topping> toppings;
    private double totalCalories;

    public Pizza() {
        toppings = new ArrayList<>();
    }

    public Pizza(String name, int numberOfToppings) {
        this();
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
    }

    public Pizza(String name, Dough dough, int numberOfToppings) {
        this(name, numberOfToppings);
        this.setDough(dough);
    }

    public Pizza(String name, Dough dough, int numberOfToppings, List<Topping> toppings) {
        this(name, dough, numberOfToppings);
        this.setToppings(toppings);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.length() > 15 || name.matches("\\s+") || name == null){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(this.toppings);
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addToToppings(Topping topping){
        this.toppings.add(topping);
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public double getTotalCalories() {
        this.setTotalCalories();
        return totalCalories;
    }

    public void setTotalCalories() {
        double totalCalories = 0;
        totalCalories += this.dough.getTotalCalories();
        for (Topping topping : this.getToppings()) {
            totalCalories += topping.getTotalCalories();
        }
        this.totalCalories = totalCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getTotalCalories());
    }
}
