package car_salesman;

public class Car {
    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car() {
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String displacement = "n/a";
        String weight = "n/a";
        String colour = "n/a";
        String efficiency = "n/a";
        if(this.engine.getDisplacement() != null){
            displacement = String.valueOf(this.engine.getDisplacement());
        }
        if(this.weight != null){
            weight = String.valueOf(this.weight);
        }
        if(this.engine.getEfficiency() != null){
            efficiency = this.engine.getEfficiency();
        }
        if(this.color != null){
            colour = this.color;
        }
        return String.format("%s: %n%s: %nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s", this.model, this.engine.getModel(), this.engine.getPower(), displacement, efficiency, weight, colour);
    }
}
