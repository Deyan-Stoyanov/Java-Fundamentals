package exam_preparation_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Examprep1Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        Map<String, String> messages = new LinkedHashMap<>();
        while(!"Ascend".equalsIgnoreCase(command = reader.readLine())) {
            Pattern pattern = Pattern.compile("[,_][a-zA-Z]+[0-9]");
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()) {
                String match = matcher.group();
                String oldMatch = match;
                for (Map.Entry<String, String> entry : messages.entrySet()) {
                    if (entry.getKey().equals(match)) {
                        match = command.substring(command.indexOf(match) - 1, command.indexOf(match)) + entry.getValue() + command.substring(command.indexOf(match) + match.length() - 1, command.indexOf(match) + match.length());
                        command = command.replace(oldMatch, match.substring(1, match.length() - 1));
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                char sign = match.charAt(0);
                int n = Integer.parseInt(Character.toString(match.charAt(match.length() - 1)));
                if (sign == ',') {
                    for (int i = 1; i < match.length() - 1; i++) {
                        stringBuilder.append((char) (match.charAt(i) + n));
                    }
                } else if (sign == '_') {
                    for (int i = 1; i < match.length() - 1; i++) {
                        stringBuilder.append((char) (match.charAt(i) - n));
                    }
                }
                messages.putIfAbsent(oldMatch, stringBuilder.toString());
                command = command.replaceAll(match, stringBuilder.toString());
                matcher = pattern.matcher(command);
            }
            System.out.println(command);
        }
    }
}
