package app.contracts;

public interface SpecialHero extends Hero{
    void assignAbility(Special special);
    Special getSpecial();
    void activateAbility();
    void deactivateAbility();
}
