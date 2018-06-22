package problem3_wild_farm.animals;

import problem3_wild_farm.food.Food;

public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), DECIMAL_FORMAT.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
