package java_advanced_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        char[] c = new char[]{'*', '-', '\\', '"', '{', '}', '[', ']', '(', ')', '.', '^', '$'};
        String command;
        while(!"Print".equalsIgnoreCase(command = reader.readLine())) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < command.length(); i++) {
                char ch = command.charAt(i);
                if(ch == '%'){
                    sb.append("[\\S]*");
                } else {
                    boolean isSpecialSymbol = false;
                    for (Character character : c) {
                        if(character == ch){
                            sb.append("\\").append(ch);
                            isSpecialSymbol = true;
                            break;
                        }
                    }
                    if(!isSpecialSymbol){
                        sb.append(ch);
                    }
                }
            }
            Pattern pattern = Pattern.compile(sb.toString());
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()) {
                String match = matcher.group();
                StringBuilder reversed = new StringBuilder();
                for (int j = match.length() - 1; j >= 0; j--) {
                    reversed.append(match.charAt(j));
                }
                text = text.replace(match, reversed.toString());
            }
        }
        System.out.println(text);
    }
}
