import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SrpskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, BigDecimal>> venues = new LinkedHashMap<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            if(command.matches("[a-zA-Z\\s]+\\s@[a-zA-Z\\s]+\\s[0-9]+\\s[0-9]+")){
                String singer = command.substring(0, command.indexOf("@")).trim();
                String[] data = command.substring(command.indexOf("@") + 1).split("\\s+");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < data.length - 2; i++) {
                    sb.append(data[i]).append(" ");
                }
                String venueName = sb.toString().trim();
                long ticketPrice = Long.parseLong(data[data.length - 2]);
                long ticketCount = Long.parseLong(data[data.length - 1]);
                BigDecimal total = BigDecimal.valueOf(ticketCount * ticketPrice);
                if(!venues.containsKey(venueName)) {
                    venues.put(venueName, new LinkedHashMap<>());
                }
                if(venues.get(venueName).containsKey(singer)){
                    venues.get(venueName).put(singer, venues.get(venueName).get(singer).add(total));
                } else {
                    venues.get(venueName).put(singer, total);
                }
            }
        }
        for (Map.Entry<String, Map<String, BigDecimal>> venue : venues.entrySet()) {
            System.out.println(venue.getKey());
            Map<String, BigDecimal> result = venue.getValue().entrySet()
                    .stream()
                    .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
            for (Map.Entry<String, BigDecimal> singer : result.entrySet()) {
                System.out.printf("#  %s -> %s%n", singer.getKey(), singer.getValue());
            }
        }
    }
}
