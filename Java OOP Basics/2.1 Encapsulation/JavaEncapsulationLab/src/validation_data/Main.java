package validation_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> people = new LinkedHashSet<>();
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");
            Person person;
            try {
                person = new Person(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                people.add(person);
            } catch (IllegalArgumentException ie){
                System.out.println(ie.getMessage());
            }
        }
        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
