package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.util.Config;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {
    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return (Targetable) Class.forName(Config.TARGETABLE_PACKAGE_PATH + className).getConstructor(String.class).newInstance(name);
    }
}
