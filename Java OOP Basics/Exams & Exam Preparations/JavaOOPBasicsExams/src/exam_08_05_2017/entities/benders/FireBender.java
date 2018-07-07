package exam_08_05_2017.entities.benders;

public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    public double getHeatAggression() {
        return heatAggression;
    }

    private void setHeatAggression(double heatAggression) {
        this.heatAggression = heatAggression;
    }

    @Override
    public double getTotalPower() {
        return this.getPower() * this.getHeatAggression();
    }

    @Override
    public String toString() {
        return String.format("###Fire Bender: %s, Power: %d, Heat Aggression: %.2f", this.getName(), this.getPower(), this.getHeatAggression());
    }
}
