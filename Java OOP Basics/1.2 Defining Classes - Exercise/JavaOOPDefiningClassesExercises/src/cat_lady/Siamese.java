package cat_lady;

public class Siamese implements Cat {

    private String name;
    private double earSize;

    public Siamese() {
    }

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getStats() {
        return earSize;
    }

    @Override
    public void setStats(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.getClass().getName().substring(this.getClass().getName().indexOf(".") + 1), this.getName(), this.getStats());

    }
}
