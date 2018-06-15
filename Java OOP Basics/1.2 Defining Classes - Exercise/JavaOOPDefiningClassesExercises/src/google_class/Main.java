package google_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap<>();
        String command;
        while (!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split(" ");
            String personName = input[0];
            if (!people.containsKey(personName)) {
                people.putIfAbsent(personName, new Person(personName));
            }
            switch (input[1]) {
                case "pokemon":
                    Pokemon pokemon = new Pokemon(input[2], input[3]);
                    people.get(personName).getPokemons().add(pokemon);
                    break;
                case "company":
                    Company company = new Company(input[2], input[3], Double.parseDouble(input[4]));
                    people.get(personName).setCompany(company);
                    break;
                case "car":
                    Car car = new Car(input[2], Integer.parseInt(input[3]));
                    people.get(personName).setCar(car);
                    break;
                case "parents":
                    Relative parent = new Relative(input[2], input[3]);
                    people.get(personName).getParents().add(parent);
                    break;
                case "children":
                    Relative child = new Relative(input[2], input[3]);
                    people.get(personName).getChildren().add(child);
                    break;
                default:
                    break;
            }
        }
        command = reader.readLine();
        StringBuilder sb = new StringBuilder();
        String searchedPersonName = command;
        people.values().stream()
                .filter(x -> x.getName().equalsIgnoreCase(searchedPersonName))
                .limit(1)
                .forEach(x -> {
                    sb.append(searchedPersonName).append(System.lineSeparator());
                    sb.append("Company: ").append(System.lineSeparator()).append(x.getCompany() == null ? "" : String.format("%s %s %.2f%n", x.getCompany().getName(), x.getCompany().getDepartment(), x.getCompany().getSalary()));
                    sb.append("Car: ").append(System.lineSeparator()).append(x.getCar() == null ? "" : String.format("%s %d%n", x.getCar().getModel(), x.getCar().getSpeed()));
                    sb.append("Pokemon: ").append(System.lineSeparator());
                    if(!x.getPokemons().isEmpty()){
                        x.getPokemons().forEach(p -> sb.append(String.format("%s %s%n", p.getName(), p.getType())));
                    }
                    sb.append("Parents: ").append(System.lineSeparator());
                    if(!x.getParents().isEmpty()){
                        x.getParents().forEach(p -> sb.append(String.format("%s %s%n", p.getName(), p.getBirthDate())));
                    }
                    sb.append("Children: ").append(System.lineSeparator());
                    if(!x.getChildren().isEmpty()){
                        x.getChildren().forEach(p -> sb.append(String.format("%s %s%n", p.getName(), p.getBirthDate())));
                    }
                });
        System.out.println(sb.toString());
    }
}
