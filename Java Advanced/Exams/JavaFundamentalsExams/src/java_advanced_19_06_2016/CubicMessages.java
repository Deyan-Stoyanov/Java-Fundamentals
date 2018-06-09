package java_advanced_19_06_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        List<String> validMessages = new ArrayList<>();
        while(!"Over!".equalsIgnoreCase(command = reader.readLine())) {
            int n = Integer.parseInt(reader.readLine());
            if(command.matches("[0-9]*[a-zA-Z]{" + n + "}[^a-zA-Z]*")){
                validMessages.add(command);
            }
        }
        Pattern pattern = Pattern.compile("([0-9]*)([a-zA-Z]+)([^a-zA-Z]*)");
        StringBuilder sb = new StringBuilder();
        for (String s : validMessages) {
            Matcher matcher = pattern.matcher(s);
            String outer = "";
            String body = "";
            List<Integer> indices = new ArrayList<>();
            if(matcher.find()){
                outer = matcher.group(1) + matcher.group(3);
                body = matcher.group(2);
            }
            for (char c : outer.toCharArray()) {
                if(Character.toString(c).matches("[0-9]")){
                    indices.add(Integer.parseInt(Character.toString(c)));
                }
            }
            sb.append(body).append(" == ");
            for (Integer index : indices) {
                if(index >= 0 && index < body.length()){
                    sb.append(body.charAt(index));
                } else {
                    sb.append(" ");
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
