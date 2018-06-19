package fragile_base_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public Animal(List<Food> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public final void eat(Food food){
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods){
        Arrays.stream(foods).forEach(this::eat);
    }
}
