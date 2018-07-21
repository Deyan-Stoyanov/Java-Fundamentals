package problem6_strategy_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<Person> peopleByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleByAge = new TreeSet<>(new AgeComparator());
        for (int i = 0; i < n; i++) {
            String[] personData = reader.readLine().split("\\s+");
            Person person = new Person(personData[0], Integer.parseInt(personData[1]));
            peopleByName.add(person);
            peopleByAge.add(person);
        }
        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}
