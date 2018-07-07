package problem10_mood3;

public class Demon extends GameObject {
    private String energy;

    protected Demon(String username, int level, String energy) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    public String getHashedPassword() {
        return String.valueOf(this.getUsername().length() * 217);
    }

    @Override
    public String getSpecialPoints() {
        return this.energy;
    }

    public String getEnergy() {
        return this.energy;
    }

    private void setEnergy(String energy) {
        this.energy = energy;
    }
}
