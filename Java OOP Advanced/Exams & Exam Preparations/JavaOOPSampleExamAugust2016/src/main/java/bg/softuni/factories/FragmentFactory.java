package bg.softuni.factories;

import bg.softuni.interfaces.Fragment;

import java.lang.reflect.InvocationTargetException;

public class FragmentFactory {

    public static Fragment createFragment(String name, String type, Integer pressureAffection) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Fragment) Class.forName("bg.softuni.models.models.fragments." + type + "Fragment").getDeclaredConstructor(String.class, Integer.class).newInstance(name, pressureAffection);
    }
}
