package panzer.factory;

import panzer.contracts.Part;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class PartFactory {
    private PartFactory(){}

    public static Part createPart(String type, String model, double weight, BigDecimal price, int special) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Part) Class.forName("panzer.models.parts." + type + "Part").getDeclaredConstructor(String.class, double.class, BigDecimal.class, int.class).newInstance(model, weight, price, special);
    }
}
