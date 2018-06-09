package java_advanced_sample_13_06_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediCode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        List<String> jedi = new ArrayList<>();
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sb.append(reader.readLine());
        }
        String text = sb.toString();
        String jediPatternString = reader.readLine();
        String messagePatternString = reader.readLine();
        Pattern jediPattern = Pattern.compile(jediPatternString + "([a-zA-Z]{"+ jediPatternString.length() + "})");
        Pattern messagePattern = Pattern.compile(messagePatternString + "([a-zA-Z0-9]{"+ messagePatternString.length() + "})");
        Matcher jediMatcher = jediPattern.matcher(text);
        while(jediMatcher.find()) {
            String m = jediMatcher.group(1);
            jedi.add(m);
            text = text.replace(m, "");
        }
        Matcher messageMatcher = messagePattern.matcher(text);
        while(messageMatcher.find()) {
            messages.add(messageMatcher.group(1));
        }
        int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index : indexes) {
            index--;
            if(!jedi.isEmpty()){
                if(index >= 0 && index < messages.size()){
                    stringBuilder.append(String.format("%s - %s%n", jedi.get(0), messages.get(index)));
                    jedi.remove(0);
                }
            } else {
                break;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
