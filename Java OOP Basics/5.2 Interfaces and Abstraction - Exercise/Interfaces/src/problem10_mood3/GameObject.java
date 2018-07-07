package problem10_mood3;

import java.text.DecimalFormat;

public abstract class GameObject implements GameObjectInterface {
    private String username;
    private String hashedPassword;
    private int level;

    protected GameObject(String username, int level) {
        this.username = username;
        this.level = level;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
        public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        if(this.getSpecialPoints().contains(".")) {
            decimalFormat = new DecimalFormat("#.0#");
        }
            return String.format("\"%s\" | \"%s\" -> %s%n%s", this.getUsername(), this.getHashedPassword(), this.getClass().getSimpleName(), decimalFormat.format(this.getLevel() * Double.parseDouble(this.getSpecialPoints())));
        }
}
