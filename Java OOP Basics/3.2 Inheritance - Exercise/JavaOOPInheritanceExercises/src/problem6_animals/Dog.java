package problem6_animals;

public class Dog extends Animal {
    public Dog(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return ("BauBau");
    }
}
