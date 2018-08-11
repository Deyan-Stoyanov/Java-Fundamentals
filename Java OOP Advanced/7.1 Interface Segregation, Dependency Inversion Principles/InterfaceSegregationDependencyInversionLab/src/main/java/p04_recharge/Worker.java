package p04_recharge;

public abstract class Worker{

    private String id;
    private int workingHours;

    protected Worker(String id) {
        this.id = id;
    }

    public void work(int hours) {
        this.workingHours += hours;
    }
}
