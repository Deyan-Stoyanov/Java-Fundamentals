package exam_08_03_2017;

import java.util.ArrayList;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    protected Center(String name) {
        this.name = name;
        this.storedAnimals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Animal> getStoredAnimals() {
        return storedAnimals;
    }

    private void setStoredAnimals(List<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }

    public void addAnimal(Animal animal){
        this.storedAnimals.add(animal);
    }

    public void removeAnimal(Animal animal){
        this.storedAnimals.remove(animal);
    }

    public void removeAll(){
        this.setStoredAnimals(new ArrayList<>());
    }
}
