package problem3_wild_farm.animals;

import problem3_wild_farm.food.Food;
import problem3_wild_farm.food.Meat;

public class Tiger extends Feline{
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Meat)){
            throw new IllegalArgumentException(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}
