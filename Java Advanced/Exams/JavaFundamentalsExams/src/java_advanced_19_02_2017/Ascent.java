package java_advanced_19_02_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> decodedMessages = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("[,_][a-zA-Z]+([0-9])");
        String command;
        while (!"Ascend".equalsIgnoreCase(command = reader.readLine())){
            Matcher matcher = pattern.matcher(command);
            while(matcher.find()) {
                String encoded = matcher.group();
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : decodedMessages.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase(encoded)){
                        String temp = command.substring(command.indexOf(encoded) - 1, command.indexOf(encoded)) + decodedMessages.get(encoded) + command.substring(command.indexOf(encoded) + encoded.length(), command.indexOf(encoded) + encoded.length() + 1);
                        command = command.replace(encoded, temp.substring(1, temp.length() - 1));
                        encoded = temp;
                    }
                }
                if(encoded.startsWith(",")){
                    for (int i = 1; i < encoded.length() - 1; i++) {
                        sb.append((char)(encoded.charAt(i) + Integer.parseInt(encoded.substring(encoded.length() - 1))));
                    }
                } else {
                    for (int i = 1; i < encoded.length() - 1; i++) {
                        sb.append((char)(encoded.charAt(i) - Integer.parseInt(encoded.substring(encoded.length() - 1))));
                    }
                }
                decodedMessages.putIfAbsent(encoded, sb.toString());
                command = command.replace(encoded, sb.toString());
            }
            System.out.println(command);
        }
    }
}
