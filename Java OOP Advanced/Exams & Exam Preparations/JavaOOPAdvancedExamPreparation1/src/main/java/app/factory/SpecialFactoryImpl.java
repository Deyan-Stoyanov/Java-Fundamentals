package app.factory;

import app.contracts.Special;
import app.contracts.SpecialFactory;
import app.util.Config;

import java.lang.reflect.InvocationTargetException;

public class SpecialFactoryImpl implements SpecialFactory {
    @Override
    public Special createSpecial(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Special) Class.forName(Config.SPECIALS_PACKAGE_PATH + type).getDeclaredConstructor().newInstance();
    }
}
