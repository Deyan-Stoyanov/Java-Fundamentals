package java_advanced_sample_13_06_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediDreams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        Pattern methodPattern = Pattern.compile("static [a-z]+ ([A-Z][a-zA-Z]+|[a-z]+[A-Z][a-z]+)\\(.*\\)");
        Pattern callingPattern = Pattern.compile("(\\s|\\.)([A-Z][a-zA-Z]+|[a-z]+[A-Z][a-z]+)\\(");
        Map<String, List<String>> methods = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sb.append(reader.readLine());
        }
        String text = sb.toString();
        while(text.contains("static")) {
            String method;
            if(text.indexOf("static") == text.lastIndexOf("static")){
                method = text;
            } else {
                method= text.substring(text.indexOf("static"), text.indexOf("static", text.indexOf("static") + 6));
            }
            Matcher methodMatcher = methodPattern.matcher(method);
            if(methodMatcher.find()){
                String currentMethodName = methodMatcher.group(1);
                List<String> callings = new ArrayList<>();
                Matcher callingMatcher = callingPattern.matcher(method);
                while(callingMatcher.find()) {
                    String match = callingMatcher.group(2);
                    if(!match.equalsIgnoreCase(currentMethodName)){
                        callings.add(match);
                    }
                }
                methods.put(currentMethodName, callings);
            }
            text = text.replace(method, "");
        }
        StringBuilder result = new StringBuilder();
        methods.entrySet().stream()
                .sorted((x, y) ->{
                    if(Integer.compare(y.getValue().size(), x.getValue().size()) == 0){
                        return x.getKey().compareTo(y.getKey());
                    }
                    return Integer.compare(y.getValue().size(), x.getValue().size());
                }).forEach(x -> {
                    result.append(String.format("%s -> ", x.getKey()));
                    if(x.getValue().isEmpty()){
                        sb.append("None");
                    } else {
                        result.append(x.getValue().size()).append(" -> ");
                        x.getValue().stream().sorted(String::compareTo).forEach(y -> result.append(y).append(", "));
                        result.delete(result.length() - 2, result.length());
                    }
                    result.append(System.lineSeparator());
        });
        if(result.toString().endsWith(", ")){
            result.delete(result.length() - 2, result.length());
        }
        System.out.println(result.toString());
    }
}
