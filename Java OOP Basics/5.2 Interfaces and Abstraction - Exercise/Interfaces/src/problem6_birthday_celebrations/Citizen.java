package problem6_birthday_celebrations;

public class Citizen implements Visitor, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen() {
    }

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
