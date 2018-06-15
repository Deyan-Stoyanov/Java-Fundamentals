package cat_lady;

public class Cymric implements Cat {

    private String name;
    private double furLength;

    public Cymric() {
    }

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
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
        return furLength;
    }

    @Override
    public void setStats(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.getClass().getName().substring(this.getClass().getName().indexOf(".") + 1), this.getName(), this.getStats());

    }
}
