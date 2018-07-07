package exam_08_03_2017;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    Map<String, Center> centers;
    List<Animal> adoptedAnimals;
    List<Animal> cleansedAnimals;
    List<Animal> castratedAnimals;

    public AnimalCenterManager() {
        this.centers = new HashMap<>();
        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        Center cleansingCenter = new CleansingCenter(name);
        this.centers.putIfAbsent(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        Center adoptionCenter = new AdoptionCenter(name);
        this.centers.putIfAbsent(name, adoptionCenter);
    }

    public void registerCastrationCenter(String name) {
        Center castrationCenter = new CastrationCenter(name);
        this.centers.putIfAbsent(name, castrationCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Animal dog = new Dog(name, age, learnedCommands, adoptionCenterName);
        centers.get(adoptionCenterName).addAnimal(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Animal cat = new Cat(name, age, intelligenceCoefficient, adoptionCenterName);
        centers.get(adoptionCenterName).addAnimal(cat);
    }
    
    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
        Center adoptionCenter = this.centers.get(adoptionCenterName);
        Center cleansingCenter = this.centers.get(cleansingCenterName);
        for (Animal animal : adoptionCenter.getStoredAnimals()) {
            if(animal.getCleansingStatus().equalsIgnoreCase("UNCLEANSED")){
                cleansingCenter.addAnimal(animal);
            }
        }
        adoptionCenter.getStoredAnimals().removeIf(x -> x.getCleansingStatus().equalsIgnoreCase("UNCLEANSED"));
    }

    public void cleanse(String cleansingCenterName){
        Center cleansingCenter = this.centers.get(cleansingCenterName);
        cleansingCenter.getStoredAnimals().forEach(Animal::changeStatus);
        for (Animal animal : cleansingCenter.getStoredAnimals()) {
            for (Center center : centers.values()) {
                if(center.getName().equals(animal.getAdoptionCenterName())){
                    center.addAnimal(animal);
                    cleansedAnimals.add(animal);
                    break;
                }
            }
        }
        cleansingCenter.removeAll();
    }

    public void adopt(String adoptionCenterName){
        Center adoptionCenter = this.centers.get(adoptionCenterName);
        adoptionCenter.getStoredAnimals().stream().filter(x -> x.getCleansingStatus().equals("CLEANSED")).forEach(x -> adoptedAnimals.add(x));
        adoptionCenter.getStoredAnimals().removeIf(x -> x.getCleansingStatus().equals("CLEANSED"));
    }

    public void printStatistics(){
        System.out.println("Paw Incorporative Regular Statistics");
        System.out.println("Adoption Centers: " + this.centers.values().stream().filter(x -> x instanceof AdoptionCenter).count());
        System.out.println("Cleansing Centers: " + this.centers.values().stream().filter(x -> x instanceof CleansingCenter).count());
        System.out.println("Adopted Animals: " + (adoptedAnimals.isEmpty() ? "None" : String.join(", ", adoptedAnimals.stream().sorted(Comparator.comparing(Animal::getName)).map(Animal::getName).collect(Collectors.toList()))));
        System.out.println("Cleansed Animals: " + (cleansedAnimals.isEmpty() ? "None" : String.join(", ", cleansedAnimals.stream().sorted(Comparator.comparing(Animal::getName)).map(Animal::getName).collect(Collectors.toList()))));
        System.out.println("Animals Awaiting Adoption: " + this.centers.values().stream().filter(x -> x instanceof AdoptionCenter).mapToInt(x -> Math.toIntExact(x.getStoredAnimals().stream().filter(y -> y.getCleansingStatus().equals("CLEANSED")).count())).sum());
        System.out.println("Animals Awaiting Cleansing: " + this.centers.values().stream().filter(x -> x instanceof CleansingCenter).mapToInt(x -> Math.toIntExact(x.getStoredAnimals().stream().filter(y -> y.getCleansingStatus().equals("UNCLEANSED")).count())).sum());
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName){
        Center adoptionCenter = this.centers.get(adoptionCenterName);
        Center castrationCenter = this.centers.get(castrationCenterName);
        for (Animal animal : adoptionCenter.getStoredAnimals()) {
            if(!animal.isCastrated()){
                castrationCenter.addAnimal(animal);
            }
        }
        adoptionCenter.getStoredAnimals().removeIf(x -> !x.isCastrated());
    }

    public void castrate(String castrationCenterName){
        Center castrationCenter = this.centers.get(castrationCenterName);
        castrationCenter.getStoredAnimals().forEach(Animal::castrate);
        for (Animal animal : castrationCenter.getStoredAnimals()) {
            for (Center center : centers.values()) {
                if(center.getName().equals(animal.getAdoptionCenterName())){
                    center.addAnimal(animal);
                    this.castratedAnimals.add(animal);
                    break;
                }
            }
        }
        castrationCenter.removeAll();
    }

    public void castrationStatistics(){
        System.out.println("Paw Inc. Regular Castration Statistics");
        System.out.println("Castration Centers: " +
                this.centers.values().stream().filter(x -> x instanceof CastrationCenter).count());
        System.out.println("Castrated Animals: " +
                (castratedAnimals.isEmpty() ?
                        "None" :
                        String.join(", ", castratedAnimals.stream()
                                .sorted(Comparator.comparing(Animal::getName))
                                .map(Animal::getName)
                                .collect(Collectors.toList()))));
    }
}
