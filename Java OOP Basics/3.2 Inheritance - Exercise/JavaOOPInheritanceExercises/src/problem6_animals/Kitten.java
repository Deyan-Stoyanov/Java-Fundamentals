package problem6_animals;

public class Kitten extends Cat {
    public Kitten(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void setGender(String gender) {
        if(!gender.equalsIgnoreCase("female")){
            throw new InvalidInputException();
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return ("Miau");
    }
}
