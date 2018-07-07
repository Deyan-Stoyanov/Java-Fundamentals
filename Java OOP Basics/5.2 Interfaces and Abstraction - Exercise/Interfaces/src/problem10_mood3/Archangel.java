package problem10_mood3;

public class Archangel extends GameObject {
    private String mana;

    protected Archangel(String username, int level, String mana) {
        super(username, level);
        this.mana = mana;
    }

    @Override
    public String getHashedPassword() {
        StringBuilder sb = new StringBuilder();
        for (int j = this.getUsername().length() - 1; j >= 0; j--) {
            sb.append(this.getUsername().charAt(j));
        }
        sb.append(this.getUsername().length() * 21);
        return sb.toString();
    }

    @Override
    public String getSpecialPoints() {
        return this.mana;
    }
}
