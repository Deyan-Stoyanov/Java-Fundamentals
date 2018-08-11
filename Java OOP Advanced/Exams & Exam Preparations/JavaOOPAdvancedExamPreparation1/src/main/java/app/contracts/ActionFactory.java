package app.contracts;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ActionFactory {
    Action create(String actionName, List<Targetable> participantNames) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException;
}
