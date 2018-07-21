package problem3_4_cards_with_power;

public enum CardSuit {

    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    CardSuit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", this.ordinal(), this.name());
    }
}
