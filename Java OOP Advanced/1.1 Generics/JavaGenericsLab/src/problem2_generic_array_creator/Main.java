package problem2_generic_array_creator;

public class Main {
    public static void main(String[] args) {

        String[] firstArray = ArrayCreator.create(10, "asd");
        for (String s : firstArray) {
            System.out.println(s);
        }

        String[] secondArray = ArrayCreator.create(String.class, 10, "asd");
        for (String s : secondArray) {
            System.out.println(s);
        }
    }
}
