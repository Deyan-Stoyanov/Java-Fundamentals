package hell.factories;

import hell.interfaces.Hero;

import java.lang.reflect.InvocationTargetException;

public class HeroFactory {
    public static Hero createHero(String type, String name){
        try {
            return (Hero) Class.forName("hell.entities.models.heroes." + type).getConstructor(String.class).newInstance(name);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
