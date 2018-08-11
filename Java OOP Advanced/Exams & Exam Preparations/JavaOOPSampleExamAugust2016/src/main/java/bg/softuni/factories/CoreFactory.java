package bg.softuni.factories;

import bg.softuni.interfaces.Core;

import java.lang.reflect.InvocationTargetException;

public class CoreFactory {

    public static Core createCore(String type, Integer durability) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Core) Class.forName("bg.softuni.models.models.cores." + type + "Core").getDeclaredConstructor(String.class, Integer.class).newInstance(type, durability);
    }
}
