package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends BaseVehicle{

    public Revenger(String model, double weight, BigDecimal price, long attack, long defence, long hitPoints) {
        super(model, weight, price.add((price.multiply(new BigDecimal(50))).divide(new BigDecimal(100))), attack + ((attack * 150) / 100), defence - ((defence * 50) / 100), hitPoints- ((hitPoints * 50) / 100));
    }
}
