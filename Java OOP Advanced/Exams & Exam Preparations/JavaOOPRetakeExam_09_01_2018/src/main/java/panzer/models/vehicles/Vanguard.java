package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle{
    public Vanguard(String model, double weight, BigDecimal price, long attack, long defence, long hitPoints) {
        super(model, weight * 2, price,  attack - ((attack * 25) / 100), defence + ((defence * 50) / 100), hitPoints + ((hitPoints * 75) / 100));
    }
}
