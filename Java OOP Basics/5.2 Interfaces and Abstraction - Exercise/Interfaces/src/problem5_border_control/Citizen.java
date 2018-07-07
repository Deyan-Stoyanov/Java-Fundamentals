package problem5_border_control;

public class Citizen implements Visitor{
    private String name;
    private int age;
    private String id;

    public Citizen() {
    }

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
