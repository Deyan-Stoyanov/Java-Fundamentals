package problem3_wild_farm.animals;

import problem3_wild_farm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Feline{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), this.getBreed(), DECIMAL_FORMAT.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
