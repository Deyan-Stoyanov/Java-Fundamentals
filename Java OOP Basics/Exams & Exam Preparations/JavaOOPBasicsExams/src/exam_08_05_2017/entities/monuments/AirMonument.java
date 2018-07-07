package exam_08_05_2017.entities.monuments;

public class AirMonument extends Monument{
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    public int getAirAffinity() {
        return airAffinity;
    }

    private void setAirAffinity(int airAffinity) {
        this.airAffinity = airAffinity;
    }

    @Override
    public int getAffinity() {
        return this.getAirAffinity();
    }

    @Override
    public String toString() {
        return String.format("###Air Monument: %s, Air Affinity: %d", this.getName(), this.getAirAffinity());
    }
}
