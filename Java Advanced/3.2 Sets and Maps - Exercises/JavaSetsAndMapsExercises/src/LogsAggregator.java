import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, TreeMap<String, Long>> logs = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            String ip = data[0];
            String name = data[1];
            Long duration = Long.parseLong(data[2]);
            if(!logs.containsKey(name)){
                logs.put(name, new TreeMap<>());
                logs.get(name).put(ip, duration);
            } else {
                if(logs.get(name).containsKey(ip)){
                    logs.get(name).put(ip, logs.get(name).get(ip) + duration);
                } else {
                    logs.get(name).put(ip, duration);
                }
            }
        }
        for (Map.Entry<String, TreeMap<String, Long>> entry : logs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum() + " " + entry.getValue().keySet());
        }
    }
}
