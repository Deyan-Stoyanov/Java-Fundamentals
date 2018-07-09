package problem1_jar_of_T;

public class Main {

    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("a");
        jar.add("b");
        jar.add("c");
        System.out.println(jar.remove());
        System.out.println(jar.get());
    }
}
