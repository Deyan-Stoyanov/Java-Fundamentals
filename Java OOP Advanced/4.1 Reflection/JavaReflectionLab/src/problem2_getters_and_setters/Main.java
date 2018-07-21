package problem2_getters_and_setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)  {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Reflection.class.getDeclaredMethods()).sorted(Comparator.comparing(Method::getName)).forEach(x -> {
            if(x.getName().startsWith("get") && !x.getReturnType().equals(void.class) && x.getParameterTypes().length == 0){
                sb.append(x.getName()).append(" will return ").append(x.getReturnType().getSimpleName()).append(System.lineSeparator());
            } else if(x.getName().startsWith("set") && x.getReturnType().equals(void.class) && x.getParameterTypes().length == 1){
                sb.append(x.getName()).append(" and will set field of ").append(x.getParameterTypes()[0].getSimpleName()).append(System.lineSeparator());
            }
        });
        System.out.println(sb.toString());
    }
}
