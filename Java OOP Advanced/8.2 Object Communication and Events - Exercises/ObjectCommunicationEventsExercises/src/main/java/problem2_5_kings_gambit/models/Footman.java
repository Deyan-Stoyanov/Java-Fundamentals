package problem2_5_kings_gambit.models;

public class Footman extends Person {
    public static final int FOOTMAN_INITIAL_HEALTH_POINTS = 2;

    public Footman(String name) {
        super(name);
        this.setHealthPoints(FOOTMAN_INITIAL_HEALTH_POINTS);
    }

    @Override
    public void behave() {
        System.out.printf("Footman %s is panicking!%n", this.getName());
    }
}
