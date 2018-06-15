package class_person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        executeProblem1();
//        executeProblem2();
//        executeProblem3(reader);


    }

    private static void executeProblem3(BufferedReader reader) throws IOException {
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            people.add(person);
        }
        StringBuilder sb = new StringBuilder();
        people.stream()
                .filter(x -> x.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(x -> sb.append(x.getName()).append(" - ").append(x.getAge()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    private static void executeProblem1() {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }

    private static void executeProblem2() throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class personClass = Person.class;
        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass
                .getDeclaredConstructor(String.class, int.class);
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        Person basePerson = (Person) emptyCtor.newInstance();
        Person personWithAge = (Person) ageCtor.newInstance(age);
        Person personFull = (Person) nameAgeCtor.newInstance(name, age);
        System.out.printf("%s %s%n", basePerson.getName(), basePerson.getAge());
        System.out.printf("%s %s%n", personWithAge.getName(), personWithAge.getAge());
        System.out.printf("%s %s%n", personFull.getName(), personFull. getAge());
    }
}
