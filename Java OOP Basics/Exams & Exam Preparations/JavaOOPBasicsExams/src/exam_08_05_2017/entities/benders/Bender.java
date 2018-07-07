package exam_08_05_2017.entities.benders;

public abstract class Bender {
    private String name;
    private int power;

    public Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public abstract double getTotalPower();

    @Override
    public String toString() {
        return super.toString();
    }
}
