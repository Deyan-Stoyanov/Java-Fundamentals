package problem5_comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String command;
        while (!"END".equalsIgnoreCase(command = reader.readLine())){
            String[] personInput = command.split("\\s+");
            Person person = new Person(personInput[0], Integer.parseInt(personInput[1]), personInput[2]);
            people.add(person);
        }
        int personIndex = Integer.parseInt(reader.readLine()) - 1;
        Person person = people.get(personIndex);
        long peopleEqual = people.stream().filter(x -> people.indexOf(x) != personIndex).filter(x -> x.compareTo(person) == 0).count() + 1;
        if(peopleEqual == 1){
            System.out.println("No matches");
        } else {
            System.out.println(peopleEqual + " " + (people.size() - peopleEqual) + " " + people.size());
        }
    }
}
