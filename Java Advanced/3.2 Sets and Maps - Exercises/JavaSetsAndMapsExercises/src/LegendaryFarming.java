import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> items = new HashMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        String legendary = "";
        boolean legendaryFound = false;
        while (true){
            String[] input = reader.readLine().split("\\s+");
            for (int i = 0; i < input.length - 1; i++) {
                String item = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);
                if(items.containsKey(item)){
                    items.put(item, items.get(item) + quantity);
                } else {
                    if(!junk.containsKey(item)){
                        junk.put(item, 0);
                    }
                    junk.put(item, junk.get(item) + quantity);
                }
                for (Map.Entry<String, Integer> entry : items.entrySet()) {
                    if(entry.getValue() >= 250){
                        switch (entry.getKey()){
                            case "shards":
                                legendary = "Shadowmourne";
                                items.put("shards", items.get("shards") - 250);
                                break;
                            case "fragments":
                                legendary = "Valanyr";
                                items.put("fragments", items.get("fragments") - 250);
                                break;
                            case "motes":
                                legendary = "Dragonwrath";
                                items.put("motes", items.get("motes") - 250);
                                break;
                            default:
                                break;
                        }
                        legendaryFound = true;
                        break;
                    }
                }
                if(legendaryFound){
                    break;
                }
                i++;
            }
            if(legendaryFound){
                break;
            }
        }
        System.out.println(legendary + " obtained!");
        Map<String, Integer> resultItems = items.entrySet().stream().sorted((x, y) ->{
            if(y.getValue() - x.getValue() == 0){
                return x.getKey().compareTo(y.getKey());
            }
            return y.getValue() - x.getValue();
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : resultItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
