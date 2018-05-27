import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String command;
        while(!"end".equalsIgnoreCase(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            String ip = data[0].substring(data[0].indexOf("=") + 1);
            String user = data[2].substring(data[2].indexOf("=") + 1);
            if(!users.containsKey(user)){
                users.put(user, new LinkedHashMap<>());
                users.get(user).put(ip, 1);
            } else {
                if(!users.get(user).containsKey(ip)){
                    users.get(user).put(ip, 0);
                }
                users.get(user).put(ip, users.get(user).get(ip) + 1);
            }
        }
        for (Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            System.out.println(user.getKey() + ": ");
            StringBuilder sb = new StringBuilder();
            user.getValue().forEach((key, value) -> sb.append(key).append(" => ").append(value).append(", "));
            String result = sb.toString().substring(0, sb.toString().lastIndexOf(",")) + ".";
            System.out.println(result);
        }
    }
}
