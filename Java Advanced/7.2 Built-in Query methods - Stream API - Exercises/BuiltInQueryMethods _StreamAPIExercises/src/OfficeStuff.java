import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> companies = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            List<String> input = Arrays.stream(reader.readLine().split("[\\s|\\-]+")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
            String companyName = input.get(0);
            String materialName = input.get(2);
            Long materialQuantity = Long.parseLong(input.get(1));
            if (!companies.containsKey(companyName)) {
                companies.put(companyName, new LinkedHashMap<>());
            }
            if (!companies.get(companyName).containsKey(materialName)) {
                companies.get(companyName).put(materialName, 0L);
            }
            companies.get(companyName).put(materialName, companies.get(companyName).get(materialName) + materialQuantity);

        }
        StringBuilder sb = new StringBuilder();
        companies.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(x -> {
                    sb.append(x.getKey()).append(": ");
                    x.getValue().forEach((key, value) -> sb.append(String.format("%s-%d, ", key, value)));
                    sb.delete(sb.length() - 2, sb.length());
                    sb.append(System.lineSeparator());
                });
        System.out.println(sb.toString());
    }
}
