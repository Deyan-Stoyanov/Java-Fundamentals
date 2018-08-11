package factory;

import abstractions.Appender;
import abstractions.Layout;

import java.lang.reflect.InvocationTargetException;

public final class AppenderFactory {
    public static Appender createAppender(String className, Layout layout) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("implementations.appenders." + className);
        return (Appender) c.getConstructor(Layout.class).newInstance(layout);
    }
}
