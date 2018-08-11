package factory;

import abstractions.Layout;

import java.lang.reflect.InvocationTargetException;

public final class LayoutFactory {
    public static Layout createLayout(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("implementations.layouts." + className);
        return (Layout) c.getConstructor().newInstance();
    }
}
