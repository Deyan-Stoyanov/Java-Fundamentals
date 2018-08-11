package app.contracts;

public interface Special {
    String getType();
    boolean requirementsMet(Targetable targetable, int initialHealth);
}
