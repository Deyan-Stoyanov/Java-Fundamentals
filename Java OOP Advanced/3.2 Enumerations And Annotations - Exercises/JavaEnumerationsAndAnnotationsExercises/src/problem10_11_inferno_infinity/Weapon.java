package problem10_11_inferno_infinity;

public class Weapon {
    private Weapons weapon;

    public Weapon(String weapon) {
        this.weapon = Enum.valueOf(Weapons.class, weapon);
    }

    public Weapons getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public void addGem(String token, int i) {
        this.weapon.addGem(token, i);
    }

    public void removeGem(int i) {
        this.weapon.removeGem(i);
    }

    @Override
    public String toString() {
        return this.weapon.toString();
    }
}
