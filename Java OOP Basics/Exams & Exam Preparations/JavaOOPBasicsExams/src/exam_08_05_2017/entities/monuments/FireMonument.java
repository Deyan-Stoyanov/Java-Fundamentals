package exam_08_05_2017.entities.monuments;

public class FireMonument extends Monument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    public int getFireAffinity() {
        return fireAffinity;
    }

    private void setFireAffinity(int fireAffinity) {
        this.fireAffinity = fireAffinity;
    }

    @Override
    public int getAffinity() {
        return this.getFireAffinity();
    }

    @Override
    public String toString() {
        return String.format("###Fire Monument: %s, Fire Affinity: %d", this.getName(), this.getFireAffinity());
    }
}
