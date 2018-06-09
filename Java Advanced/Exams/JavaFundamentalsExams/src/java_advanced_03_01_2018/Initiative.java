package java_advanced_03_01_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Initiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Station> stations = new HashSet<>();
        addValidStations(stations);
        String command;
        while(!"Recruit".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("[:]");
            String personName = input[0];
            Long facultyNumber = Long.parseLong(input[1]);
            String station = input[2];
            if(stations.stream().anyMatch(x -> x.getName().equals(station))){
                for (Station s : stations) {
                    if(s.getName().equals(station)){
                        s.getPeople().putIfAbsent(facultyNumber, personName);
                    }
                }
            }
        }
        command = reader.readLine();
        if(command.equals("DHARMA Initiative")){
            Set<Station> result = stations.stream().sorted((x, y) -> {
                if(y.getPeople().size() - x.getPeople().size() == 0){
                    return x.getName().compareTo(y.getName());
                }
                return y.getPeople().size() - x.getPeople().size();
            }).collect(Collectors.toCollection(LinkedHashSet::new));
            for (Station station : result) {
                System.out.printf("The %s has %d DHARMA recruits in it.%n", station.getName(), station.getPeople().size());
            }
        } else {
            String finalCommand = command;
            if(stations.stream().noneMatch(x -> x.getName().equals(finalCommand))){
                System.out.println("DHARMA Initiative does not have such a station!");
            } else {
                for (Station station : stations) {
                    if(station.getName().equals(command)){
                        System.out.printf("The %s station: %s%n", station.getName(), station.getMessage());
                        if(station.getPeople().isEmpty()){
                            System.out.println("No recruits.");
                        } else {
                            Map<Long, String> result = station.getPeople().entrySet()
                                    .stream()
                                    .sorted((x, y) -> Long.compare(y.getKey(), x.getKey()))
                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
                            for (Map.Entry<Long, String> entry : result.entrySet()) {
                                System.out.printf("###%s - %d%n", entry.getValue(), entry.getKey());
                            }
                        }
                    }
                }
            }
        }
    }

    private static void addValidStations(Set<Station> stations) {
        stations.add(new Station("Hydra", "Zoological Research."));
        stations.add(new Station("Arrow", "Development of defensive strategies, and Intelligence gathering."));
        stations.add(new Station("Flame", "Communication."));
        stations.add(new Station("Pearl", "Psychological Research and/or Observation."));
        stations.add(new Station("Orchid", "Space-time manipulation research, disguised as a Botanical station."));
    }

    private static class Station{
        private String name;
        private Map<Long, String> people;
        private String message;

        public Station(String name, String message) {
            this.name = name;
            this.people = new HashMap<Long, String>();
            this.message = message;
        }

        public Station() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<Long, String> getPeople() {
            return people;
        }

        public void setPeople(Map<Long, String> people) {
            this.people = people;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
