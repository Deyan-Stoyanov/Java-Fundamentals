package app.factories;

import app.entities.powers.Power;
import app.entities.powers.SuperPower;

public final class SuperPowerFactory {

    private SuperPowerFactory() {
    }

    public static SuperPower createSuperPower(String name, double powerPoints){
        return new Power(name, powerPoints);
    }
}
