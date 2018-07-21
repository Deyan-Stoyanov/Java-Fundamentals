package problem7_equality_logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> peopleHashSet = new HashSet<>();
        Set<Person> peopleTreeSet = new TreeSet<>(new PersonComparator());
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] personData = reader.readLine().split("\\s+");
            Person person = new Person(personData[0], Integer.parseInt(personData[1]));
            if(peopleHashSet.stream().noneMatch(x -> x.equals(person)) && peopleTreeSet.stream().noneMatch(x -> x.equals(person))){
                peopleHashSet.add(person);
                peopleTreeSet.add(person);
            }
        }
        System.out.println(peopleHashSet.size());
        System.out.println(peopleTreeSet.size());
    }
}
