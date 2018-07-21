package problem5_coding_tracker;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> currentClass){
        Map<String, List<Method>> methodsAndAuthors = new LinkedHashMap<>();
        Method[] methods = currentClass.getDeclaredMethods();
        for (Method method : methods) {
            Author author = method.getDeclaredAnnotation(Author.class);
            if(!methodsAndAuthors.containsKey(author.name())){
                methodsAndAuthors.put(author.name(), new ArrayList<>());
            }
            methodsAndAuthors.get(author.name()).add(method);
        }
        for (Map.Entry<String, List<Method>> listEntry : methodsAndAuthors.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(listEntry.getKey()).append(": ");
            for (Method method : listEntry.getValue()) {
                sb.append(method.getName()).append("(), ");
            }
            System.out.println(sb.substring(0, sb.length() - 2));
        }
    }

    @Author(name = "Pesho")
    public static void main(String[] args) {
        Main.printMethodsByAuthor(Main.class);
    }
}
