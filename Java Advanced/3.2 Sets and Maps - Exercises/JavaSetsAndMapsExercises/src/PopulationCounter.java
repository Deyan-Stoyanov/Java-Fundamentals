import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<City>> countries = new LinkedHashMap<>();
        String command;
        while (!"report".equalsIgnoreCase(command = reader.readLine())) {
            String[] data = command.split("\\|");
            String cityName = data[0];
            String countryName = data[1];
            Long population = Long.parseLong(data[2]);
            if (!countries.containsKey(countryName)) {
                countries.put(countryName, new HashSet<>());
            }
            if (countries.get(countryName).stream().noneMatch(x -> x.getName().equalsIgnoreCase(cityName))) {
                countries.get(countryName).add(new City(cityName, population));
            }
        }

        Map<String, Set<City>> result = countries
                .entrySet()
                .stream()
                .sorted((x, y) -> Long.compare((y.getValue().stream().mapToLong(City::getPopulation)).sum(), x.getValue().stream().mapToLong(City::getPopulation).sum()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Set<City>> country : result.entrySet()) {
            System.out.printf("%s (total population: %d)%n", country.getKey(), country
                    .getValue()
                    .stream()
                    .mapToLong(City::getPopulation)
                    .sum());

            Set<City> citiesOfCountry = country
                    .getValue()
                    .stream()
                    .sorted((x, y) -> Long.compare(y.getPopulation(), x.getPopulation()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            for (City city : citiesOfCountry) {
                System.out.printf("=>%s: %d%n", city.getName(), city.getPopulation());
            }
        }
    }

    static class City {
        private String name;
        private long population;

        public City(String name, Long population) {
            this.name = name;
            this.population = population;
        }

        public City() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }
    }
}
