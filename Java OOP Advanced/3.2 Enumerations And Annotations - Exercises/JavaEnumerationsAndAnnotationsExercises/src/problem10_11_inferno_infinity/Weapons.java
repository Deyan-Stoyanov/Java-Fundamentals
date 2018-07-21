package problem10_11_inferno_infinity;

import java.util.Arrays;
import java.util.Objects;

public enum Weapons {
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


    @Override
    public String toString() {
        int totalStrength = Arrays.stream(this.sockets).filter(Objects::nonNull).mapToInt(Gems::getStrength).sum();
        int totalAgility = Arrays.stream(this.sockets).filter(Objects::nonNull).mapToInt(Gems::getAgility).sum();
        int totalVitality = Arrays.stream(this.sockets).filter(Objects::nonNull).mapToInt(Gems::getVitality).sum();
        int totalMinDamage = this.minDamage + ((totalStrength * 2) + totalAgility);
        int totalMaxDamage = this.maxDamage + ((totalStrength * 3) + (totalAgility * 4));
        return String.format("%d-%d Damage, +%d Strength, +%d Agility, +%d Vitality", totalMinDamage, totalMaxDamage, totalStrength, totalAgility, totalVitality);
    }
}
