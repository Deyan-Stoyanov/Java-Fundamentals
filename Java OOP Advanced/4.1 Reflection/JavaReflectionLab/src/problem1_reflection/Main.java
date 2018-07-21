package problem1_reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Ref;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Reflection> reflectionClass = Reflection.class;
        Reflection reflection = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());

        for (Class anInterface : reflectionClass.getInterfaces()) {
            System.out.println(anInterface);
        }
        System.out.println(reflectionClass.getDeclaredConstructor().newInstance());


     /*
        //Examples:

        //Fields:
        Field field = Reflection.class.getDeclaredField("zip");
        field.setAccessible(true);
        Object value = field.get(reflection);
        System.out.println(value);
        field.set(reflection, 1234);
        value = field.get(reflection);
        System.out.println(value);


        //Methods:
        Method[] methods = Reflection.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(String.join(", ", Arrays.stream(method.getParameterTypes()).map(Class::toString).collect(Collectors.toList())));
        }

        Method reflToString = Reflection.class.getDeclaredMethod("setEmail", String.class);
        System.out.println(reflToString.getName() + ", " + reflToString.getReturnType());

        Method getter = Reflection.class.getDeclaredMethod("getName");
        Class returnType = getter.getReturnType();
        Object result = returnType.cast(getter.invoke(reflection));
        System.out.println(result);

        //Modifiers:
        int modifiers = reflectionClass.getModifiers();
        System.out.println(Modifier.isPublic(modifiers));

        //Annotations:
        Annotation[] annotations = reflectionClass.getMethod("toString").getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString() + annotation.annotationType());
        }

        //Arrays:
        int[] arr = new int[2];
        System.out.println(arr.getClass().getComponentType());
                                */
    }
}