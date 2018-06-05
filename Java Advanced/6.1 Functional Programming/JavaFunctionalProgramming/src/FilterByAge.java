import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputLine = reader.readLine().split("[,\\s]+");
            people.put(inputLine[0], Integer.parseInt(inputLine[1]));
        }
        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String dataToPrint = reader.readLine();

        BiPredicate<int[], String> checkAge = (ageData, typeOfCondition) -> {
            int ageOfPerson = ageData[0];
            int restriction = ageData[1];
            switch (typeOfCondition){
                case "older":
                    return ageOfPerson >= restriction;
                case "younger":
                    return ageOfPerson < restriction;
                default:break;
            }
            return false;
        };

        BiConsumer<Map.Entry<String, Integer>, String> printResult = (entry, format) -> {
              switch (format){
                  case "name":
                      System.out.println(entry.getKey());
                      break;
                  case "age":
                      System.out.println(entry.getValue());
                      break;
                  case "name age":
                      System.out.println(entry.getKey() + " - " + entry.getValue());
                      break;
              }
        };

        people.entrySet()
                .stream()
                .filter(x -> checkAge.test(new int[]{x.getValue(), age}, condition))
                .forEach(x -> printResult.accept(x, dataToPrint));
    }
}
