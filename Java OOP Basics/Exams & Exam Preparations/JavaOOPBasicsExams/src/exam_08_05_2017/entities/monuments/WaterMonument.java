package exam_08_05_2017.entities.monuments;

public class WaterMonument extends Monument{
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    public int getWaterAffinity() {
        return waterAffinity;
    }

    private void setWaterAffinity(int waterAffinity) {
        this.waterAffinity = waterAffinity;
    }

    @Override
    public int getAffinity() {
        return this.getWaterAffinity();
    }

    @Override
    public String toString() {
        return String.format("###Water Monument: %s, Water Affinity: %d", this.getName(), this.getWaterAffinity());
    }
}
