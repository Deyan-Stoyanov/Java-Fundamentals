package exam_08_05_2017.entities.monuments;

public class EarthMonument extends Monument{
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    public int getEarthAffinity() {
        return earthAffinity;
    }

    private void setEarthAffinity(int earthAffinity) {
        this.earthAffinity = earthAffinity;
    }


    @Override
    public int getAffinity() {
        return this.getEarthAffinity();
    }

    @Override
    public String toString() {
        return String.format("###Earth Monument: %s, Earth Affinity: %d", this.getName(), this.getEarthAffinity());
    }
}
