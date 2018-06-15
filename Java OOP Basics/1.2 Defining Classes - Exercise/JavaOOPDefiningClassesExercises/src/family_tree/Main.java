package family_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> people = new LinkedHashSet<>();
        Person person = new Person();
        String command = reader.readLine();
        if (command.matches("[0-9]+/[0-9]+/[0-9]+")) {
            person.setBirthDate(command);
        } else {
            person.setName(command);
        }
        people.add(person);
        while (!"End".equalsIgnoreCase(command = reader.readLine())) {
            if (command.contains("-")) {
                String[] input = command.split(" - ");
                if (input[0].matches("[0-9]+/[0-9]+/[0-9]+") && input[1].matches("[0-9]+/[0-9]+/[0-9]+")) {
                    addPeopleByTwoDates(people, input);
                } else if (input[0].matches("[0-9]+/[0-9]+/[0-9]+")) {
                    addPeopleByDateAndName(people, input);
                } else if (input[1].matches("[0-9]+/[0-9]+/[0-9]+")) {
                    AddPeopleByNameAndDate(people, input);
                } else {
                    addPeopleByTwoNames(people, input);
                }
            } else {
                addNewPersonToList(people, command);
            }
        }
        String result = getOutputString(people, person);
        System.out.println(result);
    }

    private static String getOutputString(Set<Person> people, Person person) {
        StringBuilder sb = new StringBuilder();

        people.stream()
                .filter(x -> x.getName().equals(person.getName()) && x.getBirthDate().equalsIgnoreCase(person.getBirthDate())).limit(1)
                .forEach(x -> {
                    sb.append(String.format("%s %s%n", x.getName(), x.getBirthDate())).append("Parents:").append(System.lineSeparator());
                    people.forEach(y -> {
                        if(y.getChildren().stream().anyMatch(c -> c.getName().equalsIgnoreCase(x.getName()) || c.getBirthDate().equalsIgnoreCase(x.getBirthDate()))){
                            sb.append(String.format("%s %s%n", y.getName(), y.getBirthDate()));
                        }
                    });
                    if (!x.getParents().isEmpty()) {
                        x.getParents().forEach(p -> sb.append(String.format("%s %s%n", p.getName(), p.getBirthDate())));
                    }
                    sb.append("Children:").append(System.lineSeparator());
                    if (!x.getChildren().isEmpty()) {
                        x.getChildren().forEach(c -> sb.append(String.format("%s %s%n", c.getName(), c.getBirthDate())));
                    }
                });
        return sb.toString();
    }

    private static void addNewPersonToList(Set<Person> people, String command) {
        Pattern pattern = Pattern.compile("[0-9]+/[0-9]+/[0-9]+");
        Matcher matcher = pattern.matcher(command);
        String date = "";
        if(matcher.find()){
            date = matcher.group();
        }
        String name = command.substring(0, command.indexOf(date) - 1);
        boolean personAdded = false;
        for (Person person1 : people) {
            if (person1.getBirthDate().equalsIgnoreCase(date) || person1.getName().equalsIgnoreCase(name)) {
                person1.setName(name);
                person1.setBirthDate(date);
                personAdded = true;
                break;
            }
        }
        if (!personAdded) {
            people.add(new Person(name, date));
        }
    }

    private static void addPeopleByTwoNames(Set<Person> people, String[] input) {
        if (people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[0])) && people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[1]))) {
            for (Person parent : people) {
                if (parent.getName().equalsIgnoreCase(input[0])) {
                    for (Person child : people) {
                        if (parent.getName().equalsIgnoreCase(input[1])) {
                            parent.getChildren().add(child);
                            child.getParents().add(parent);
                        }
                    }
                }
            }
        } else if (people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[0]))) {
            Person child = new Person();
            for (Person parent : people) {
                if (parent.getName().equalsIgnoreCase(input[0])) {
                    child.setName(input[1]);
                    child.getParents().add(parent);
                    parent.getChildren().add(child);
                    break;
                }
            }
            people.add(child);
        } else if (people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[1]))) {
            Person parent = new Person();
            parent.setName(input[0]);
            for (Person child : people) {
                if (child.getName().equalsIgnoreCase(input[1])) {
                    parent.getChildren().add(child);
                    child.getParents().add(parent);
                    break;
                }
            }
            people.add(parent);
        } else {
            Person parent = new Person();
            parent.setName(input[0]);
            Person child = new Person();
            child.setName(input[1]);
            parent.getChildren().add(child);
            child.getParents().add(parent);
            people.add(parent);
            people.add(child);
        }
    }

    private static void AddPeopleByNameAndDate(Set<Person> people, String[] input) {
        if (people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[0])) && people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[1]))) {
            for (Person parent : people) {
                if (parent.getName().equalsIgnoreCase(input[0])) {
                    for (Person child : people) {
                        if (child.getBirthDate().equalsIgnoreCase(input[1])) {
                            parent.getChildren().add(child);
                            child.getParents().add(parent);
                        }
                    }
                }
            }
        } else if (people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[0]))) {
            Person child = new Person();
            for (Person parent : people) {
                if (parent.getName().equalsIgnoreCase(input[0])) {
                    child.setBirthDate(input[1]);
                    child.getParents().add(parent);
                    parent.getChildren().add(child);
                    break;
                }
            }
            people.add(child);

        } else if (people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[1]))) {
            Person parent = new Person();
            parent.setName(input[0]);
            for (Person child : people) {
                if (child.getBirthDate().equalsIgnoreCase(input[1])) {
                    parent.getChildren().add(child);
                    child.getParents().add(parent);
                    break;
                }
            }
            people.add(parent);
        } else {
            Person parent = new Person();
            parent.setName(input[0]);
            Person child = new Person();
            child.setBirthDate(input[1]);
            parent.getChildren().add(child);
            child.getParents().add(parent);
            people.add(parent);
            people.add(child);
        }
    }

    private static void addPeopleByDateAndName(Set<Person> people, String[] input) {
        if (people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[0])) && people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[1]))) {
            for (Person parent : people) {
                if (parent.getBirthDate().equalsIgnoreCase(input[0])) {
                    for (Person child : people) {
                        if (child.getName().equalsIgnoreCase(input[1])) {
                            parent.getChildren().add(child);
                            child.getParents().add(parent);
                        }
                    }
                }
            }
        } else if (people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[0]))) {
            Person child = new Person();
            for (Person parent : people) {
                if (parent.getBirthDate().equalsIgnoreCase(input[0])) {
                    child.setName(input[1]);
                    child.getParents().add(parent);
                    parent.getChildren().add(child);
                    break;
                }
            }
            people.add(child);
        } else if (people.stream().anyMatch(x -> x.getName().equalsIgnoreCase(input[1]))) {
            Person parent = new Person();
            parent.setBirthDate(input[0]);
            for (Person child : people) {
                if (child.getName().equalsIgnoreCase(input[1])) {
                    parent.getChildren().add(child);
                    child.getParents().add(parent);
                    break;
                }
            }
            people.add(parent);
        } else {
            Person parent = new Person();
            parent.setBirthDate(input[0]);
            Person child = new Person();
            child.setName(input[1]);
            parent.getChildren().add(child);
            child.getParents().add(parent);
            people.add(parent);
            people.add(child);
        }
    }

    private static void addPeopleByTwoDates(Set<Person> people, String[] input) {
        if (people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[0])) && people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[1]))) {
            for (Person parent : people) {
                if (parent.getBirthDate().equalsIgnoreCase(input[0])) {
                    for (Person child : people) {
                        if (child.getBirthDate().equalsIgnoreCase(input[1])) {
                            parent.getChildren().add(child);
                            child.getParents().add(parent);
                        }
                    }
                }
            }
        } else if (people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[0]))) {
            Person child = new Person();
            for (Person parent : people) {
                if (parent.getBirthDate().equalsIgnoreCase(input[0])) {
                    child.setBirthDate(input[1]);
                    child.getParents().add(parent);
                    parent.getChildren().add(child);
                    break;
                }
            }
            people.add(child);
        } else if (people.stream().anyMatch(x -> x.getBirthDate().equalsIgnoreCase(input[1]))) {
            Person parent = new Person();
            parent.setBirthDate(input[0]);
            for (Person child : people) {
                if (child.getBirthDate().equalsIgnoreCase(input[1])) {
                    parent.getChildren().add(child);
                    child.getParents().add(parent);
                    break;
                }
            }
            people.add(parent);
        } else {
            Person parent = new Person();
            parent.setBirthDate(input[0]);
            Person child = new Person();
            child.setBirthDate(input[1]);
            parent.getChildren().add(child);
            child.getParents().add(parent);
            people.add(parent);
            people.add(child);
        }
    }
}
