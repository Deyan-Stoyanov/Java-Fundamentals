package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

public class WasteFactory {
    public static Waste createWaste(String name, double weight, double volumePerKg, String type){
        try {
            return (Waste) Class.forName("app.waste_disposal.models.waste." + type + "Garbage").getConstructor(String.class, double.class, double.class).newInstance(name, weight, volumePerKg);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
