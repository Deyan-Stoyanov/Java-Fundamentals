package app.contracts;

import java.lang.reflect.InvocationTargetException;

public interface SpecialFactory {
    Special createSpecial(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
