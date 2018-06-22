package problem3_wild_farm;

import problem3_wild_farm.animals.*;
import problem3_wild_farm.food.Food;
import problem3_wild_farm.food.Meat;
import problem3_wild_farm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        List<Animal> animals = new ArrayList<>();
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] animalData = command.split("\\s+");
            String[] foodData = reader.readLine().split("\\s+");
            Animal animal = getAnimal(animalData);
            Food food = getFood(foodData);
            printAnimalInfo(animals, animal, food);
        }
        animals.forEach(System.out::println);
    }

    private static void printAnimalInfo(List<Animal> animals, Animal animal, Food food) {
        if (animal != null) {
            animal.makeSound();
            if(food != null){
                try {
                    animal.eat(food);
                } catch (IllegalArgumentException ie){
                    System.out.println(ie.getMessage());
                }
            }
            animals.add(animal);
        }
    }

    private static Food getFood(String[] foodData) {
        Food food = null;
        switch (foodData[0]){
            case "Vegetable":
                food = new Vegetable(Integer.parseInt(foodData[1]));
                break;
            case "Meat":
                food = new Meat(Integer.parseInt(foodData[1]));
                break;
        }
        return food;
    }

    private static Animal getAnimal(String[] animalData) {
        Animal animal = null;
        switch (animalData[0]){
            case "Cat":
                animal = new Cat(animalData[1], animalData[0], Double.parseDouble(animalData[2]), animalData[3], animalData[4]);
                break;
            case "Tiger":
                animal = new Tiger(animalData[1], animalData[0], Double.parseDouble(animalData[2]), animalData[3]);
                break;
            case "Mouse":
                animal = new Mouse(animalData[1], animalData[0], Double.parseDouble(animalData[2]), animalData[3]);
                break;
            case "Zebra":
                animal = new Zebra(animalData[1], animalData[0], Double.parseDouble(animalData[2]), animalData[3]);
                break;
        }
        return animal;
    }
}
