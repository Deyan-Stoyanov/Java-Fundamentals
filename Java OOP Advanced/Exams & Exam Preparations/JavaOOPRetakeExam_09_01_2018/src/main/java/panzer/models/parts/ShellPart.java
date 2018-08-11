package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends BasePart implements DefenseModifyingPart {
    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("+%d Defence",
                this.getDefenseModifier());
    }
}
