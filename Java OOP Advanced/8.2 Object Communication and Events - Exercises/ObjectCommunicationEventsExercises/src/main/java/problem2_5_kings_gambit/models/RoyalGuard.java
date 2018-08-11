package problem2_5_kings_gambit.models;

public class RoyalGuard extends Person {
    public static final int ROYAL_GUARD_INITIAL_HEALTH_POINTS = 3;

    public RoyalGuard(String name) {
        super(name);
        this.setHealthPoints(ROYAL_GUARD_INITIAL_HEALTH_POINTS);
    }

    @Override
    public void behave() {
        System.out.printf("Royal Guard %s is defending!%n", this.getName());
    }
}
