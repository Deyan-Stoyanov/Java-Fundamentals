package problem6_birthday_celebrations;

public class Robot implements Visitor {
    private String model;
    private String id;

    public Robot() {
    }

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
