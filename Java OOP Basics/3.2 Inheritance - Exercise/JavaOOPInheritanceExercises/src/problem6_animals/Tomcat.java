package problem6_animals;

public class Tomcat extends Cat {
    public Tomcat(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void setGender(String gender) {
        if(!gender.equalsIgnoreCase("male")){
            throw new InvalidInputException();
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return ("Give me one million b***h");
    }
}
