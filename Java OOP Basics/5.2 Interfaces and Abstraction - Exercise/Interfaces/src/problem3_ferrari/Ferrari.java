package problem3_ferrari;

public class Ferrari implements Car{
    private String model;
    private String driverName;

    public Ferrari() {
    }

    public Ferrari(String model, String driverName) {
        this.model = model;
        this.driverName = driverName;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.getModel(), this.brakes(), this.gasPedal(), this.getDriverName());
    }
}
