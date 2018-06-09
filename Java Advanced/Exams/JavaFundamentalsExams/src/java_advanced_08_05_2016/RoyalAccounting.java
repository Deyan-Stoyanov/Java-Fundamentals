package java_advanced_08_05_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class RoyalAccounting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<Person>> teams = new LinkedHashMap<>();
        String command;
        while(!"Pishi kuf i da si hodim".equalsIgnoreCase(command = reader.readLine())){
            if(command.matches("[a-zA-Z]+;\\-?[0-9]+;\\-?[0-9]+(\\.[0-9]+)?;[a-zA-Z]+")){
                String[] input = command.split(";");
                String team = input[3];
                String personName = input[0];
                Integer hours = Integer.parseInt(input[1]);
                Double payment = Double.parseDouble(input[2]);
                if(teams.values().stream().noneMatch(x -> x.stream().anyMatch(y -> y.getName().equals(personName)))){
                    if(!teams.containsKey(team)){
                        teams.putIfAbsent(team, new LinkedHashSet<>());
                    }
                    teams.get(team).add(new Person(personName, hours, payment));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        teams.entrySet().stream()
                .filter(x -> !x.getValue().isEmpty())
                .sorted((x, y) -> Double.compare(y.getValue().stream().mapToDouble(Person::monthlyPayment).sum(), x.getValue().stream().mapToDouble(Person::monthlyPayment).sum()))
                .forEach(x -> {
                    sb.append("Team - ").append(x.getKey()).append(System.lineSeparator());
                    x.getValue().stream()
                            .sorted((e1, e2) -> {
                                if(e2.getWorkHoursPerDay().equals(e1.getWorkHoursPerDay())){
                                    if(e2.dailyIncome().equals(e1.dailyIncome())){
                                        return e1.getName().compareTo(e2.getName());
                                    }
                                    return Double.compare(e2.dailyIncome(), e1.dailyIncome());
                                }
                                return Double.compare(e2.getWorkHoursPerDay(), e1.getWorkHoursPerDay());
                            }).forEach(e -> sb.append(String.format("$$$%s - %d - %.6f%n", e.getName(), e.getWorkHoursPerDay(), e.dailyIncome())));
                });
        System.out.println(sb.toString());
    }

    private static class Person{
        private String name;
        private Integer workHoursPerDay;
        private Double dailyPayment;

        public Person(String name, Integer workHoursPerDay, Double dailyPayment) {
            this.name = name;
            this.workHoursPerDay = workHoursPerDay;
            this.dailyPayment = dailyPayment;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getWorkHoursPerDay() {
            return workHoursPerDay;
        }

        public void setWorkHoursPerDay(Integer workHoursPerDay) {
            this.workHoursPerDay = workHoursPerDay;
        }

        public Double getDailyPayment() {
            return dailyPayment;
        }

        public void setDailyPayment(Double dailyPayment) {
            this.dailyPayment = dailyPayment;
        }

        public Double monthlyPayment(){
            return ((this.getDailyPayment() * this.getWorkHoursPerDay()) / 24) * 30;
        }

        public Double dailyIncome(){
            return (this.getDailyPayment() * this.getWorkHoursPerDay()) / 24;
        }
    }
}
