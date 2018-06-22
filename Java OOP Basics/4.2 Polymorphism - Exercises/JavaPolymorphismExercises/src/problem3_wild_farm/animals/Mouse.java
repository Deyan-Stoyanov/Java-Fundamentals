package problem3_wild_farm.animals;

import problem3_wild_farm.food.Food;
import problem3_wild_farm.food.Meat;
import problem3_wild_farm.food.Vegetable;

public class Mouse extends Mammal{

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Vegetable)){
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}
