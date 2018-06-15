package cat_lady;

public class StreetExtraordinaire implements Cat {

    private String name;
    private double decibels;

    public StreetExtraordinaire() {
    }

    public StreetExtraordinaire(String name, double decibels) {
        this.name = name;
        this.decibels = decibels;
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
        return decibels;
    }

    @Override
    public void setStats(double decibels) {
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.getClass().getName().substring(this.getClass().getName().indexOf(".") + 1), this.getName(), this.getStats());

    }
}
