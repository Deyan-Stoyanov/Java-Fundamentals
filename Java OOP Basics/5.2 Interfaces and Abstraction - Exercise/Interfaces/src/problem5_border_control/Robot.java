package problem5_border_control;

public class Robot implements Visitor{
    private String model;
    private String id;

    public Robot() {
    }

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }


    @Override
    public String getName() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
