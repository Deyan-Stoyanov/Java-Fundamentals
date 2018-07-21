import problem1_reflection.Reflection;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Class<Reflection> reflectionClass = Reflection.class;

        Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(x -> !Modifier.isPrivate(x.getModifiers()))
                .forEach(x -> System.out.println(x.getName() + " must be private!"));

       Arrays.stream(Reflection.class.getMethods())
                .filter(x -> x.getName().startsWith("get") &&
                        !x.getReturnType().equals(void.class) &&
                        x.getParameterTypes().length == 0)
                .filter(x -> !Modifier.isPublic(x.getModifiers()))
                .forEach(x -> System.out.println(x.getName() + " have to be public!"));

        Arrays.stream(Reflection.class.getMethods())
                .filter(x -> x.getName().startsWith("set") &&
                        x.getReturnType().equals(void.class) &&
                        x.getParameterTypes().length == 1)
                .filter(x -> !Modifier.isPrivate(x.getModifiers()))
                .forEach(x -> System.out.println(x + " have to be private!"));


    }
}
