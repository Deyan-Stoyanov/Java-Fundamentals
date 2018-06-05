import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> towns = new HashMap<>();
        String[] input = reader.readLine().split("\\s+");
        for (String s : input) {
            String townName = s.substring(0, s.indexOf(":"));
            int districtPopulation = Integer.parseInt(s.substring(s.indexOf(":") + 1));
            towns.putIfAbsent(townName, new ArrayList<>());
            towns.get(townName).add(districtPopulation);
        }
        int bound = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        towns.entrySet().stream()
                .filter(x -> x.getValue().stream().mapToInt(Integer::valueOf).sum() > bound)
                .sorted((x, y) -> Integer.compare(y.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        x.getValue().stream().mapToInt(Integer::valueOf).sum()))
                .forEach(x -> {
                    sb.append(x.getKey()).append(": ");
                    x.getValue().stream()
                            .sorted((a, b) -> Integer.compare(b, a))
                            .limit(5)
                            .forEach(a -> sb.append(a).append(" "));
                    sb.append(System.lineSeparator());
                });

        System.out.println(sb.toString());
    }
}
