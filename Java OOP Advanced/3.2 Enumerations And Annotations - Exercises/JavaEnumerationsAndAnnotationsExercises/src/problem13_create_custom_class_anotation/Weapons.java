package problem13_create_custom_class_anotation;

import java.util.Arrays;
import java.util.Objects;

@CustomAnnotation(author = "Pesho", revision = 3, description = "Used for Java OOP Advanced course - Enumerations and Annotations.", reviewers = {"Pesho", "Svetlio"})
public enum Weapons implements Comparable<Weapons> {
    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int socketsCount;

    private Gems[] sockets;

    Weapons(int minDamage, int maxDamage, int socketsCount) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.socketsCount = socketsCount;
        this.sockets = new Gems[socketsCount];
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public int getSocketsCount() {
        return this.socketsCount;
    }

    public void addGem(String gemName, int index){
        try {
            this.sockets[index] = Enum.valueOf(Gems.class, gemName);
        } catch (Exception ignored){}
    }

    public void removeGem(int index){
        try {
            this.sockets[index] = null;
        } catch (Exception ignored){}
    }

    public double getItemLevel(){
        return ((this.getTotalMinDamage() + this.getTotalMaxDamage()) / 2.0) + this.getTotalAgility() + this.getTotalStrength() + this.getTotalVitality();
    }

    public int getTotalStrength(){
        return Arrays.stream(this.sockets).filter(Objects::nonNull).mapToInt(Gems::getStrength).sum();
    }

    public int getTotalAgility(){
        return Arrays.stream(this.sockets).filter(Objects::nonNull).mapToInt(Gems::getAgility).sum();
    }

    public int getTotalVitality(){
        return Arrays.stream(this.sockets).filter(Objects::nonNull).mapToInt(Gems::getVitality).sum();
    }

    public int getTotalMinDamage(){
        return this.minDamage + ((getTotalStrength() * 2) + getTotalAgility());
    }

    public int getTotalMaxDamage(){
        return this.maxDamage + ((getTotalStrength() * 3) + (getTotalAgility() * 4));
    }

    @Override
    public String toString() {
        return String.format("%d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)", this.getTotalMinDamage(), this.getTotalMaxDamage(), this.getTotalStrength(), this.getTotalAgility(), this.getTotalVitality(), this.getItemLevel());
    }
}
