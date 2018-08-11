package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.contracts.Targetable;
import app.util.Config;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class ActionFactoryImpl implements ActionFactory {
    @Override
    public Action create(String actionName, List<Targetable> participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return (Action) Class.forName(Config.ACTION_PACKAGE_PATH + actionName).getConstructor(List.class).newInstance(participantNames);
    }
}
