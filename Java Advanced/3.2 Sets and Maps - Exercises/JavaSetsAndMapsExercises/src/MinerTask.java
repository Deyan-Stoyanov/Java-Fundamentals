import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        Map<String, Long> materials = new LinkedHashMap<>();
        while (!"stop".equalsIgnoreCase(command = reader.readLine())){
            long quantity = Long.parseLong(reader.readLine());
            if(!materials.containsKey(command)){
                materials.put(command, quantity);
            } else {
                materials.put(command, materials.get(command) + quantity);
            }
        }
        for (Map.Entry<String, Long> entry : materials.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
