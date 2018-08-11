package panzer.factory;

import panzer.contracts.Vehicle;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class VehicleFactory {
    private VehicleFactory(){}

    public static Vehicle createVehicle(String type, String model, double weight, BigDecimal price, long attack, long defence, long hitPoints) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Vehicle) Class.forName("panzer.models.vehicles." + type).getDeclaredConstructor(String.class, double.class, BigDecimal.class, long.class, long.class, long.class).newInstance(model, weight, price, attack, defence, hitPoints);
    }
}
