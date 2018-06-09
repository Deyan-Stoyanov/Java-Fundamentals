package exam_preparation_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Examprep2DHARMASupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = 0;
        int crates = 0;
        StringBuilder sb = new StringBuilder();
        String command;
        Pattern cratePattern = Pattern.compile("\\[.*?]");
        while(!"Collect".equalsIgnoreCase(command = reader.readLine())) {
            Matcher matcher = cratePattern.matcher(command);
            while(matcher.find()) {
                crates++;
            }
            sb.append(command).append(System.lineSeparator());
            lines++;
        }
        command = sb.toString();
        int n = crates / lines;
        int validCrates = 0;
        long foodSum = 0;
        long drinkSum = 0;
        cratePattern = Pattern.compile("\\[(#[0-9]{" + n + "})[a-zA-Z0-9\\s]*\\1]");
        Matcher matcher = cratePattern.matcher(command);
        while(matcher.find()) {
            String match = matcher.group();
            match = match.substring(1, match.lastIndexOf("]"));
            long tempFoodSum = 0;
            int tagLength = match.substring(match.lastIndexOf("#") + 1).length();
            char[] body = match.substring(match.indexOf("#") + tagLength + 1, match.lastIndexOf("#")).toCharArray();
            Set<Character> chars = new HashSet<>();
            for (char c : body) {
                chars.add(c);
            }
            for (Character aChar : chars) {
                tempFoodSum += aChar;
            }
            tempFoodSum *= tagLength;
            foodSum += tempFoodSum;
            validCrates++;
        }
        cratePattern = Pattern.compile("\\[(#[a-z]{" + n + "})[a-zA-Z0-9\\s]*\\1]");
        matcher = cratePattern.matcher(command);
        while(matcher.find()) {
            String match = matcher.group();
            match = match.substring(1, match.lastIndexOf("]"));
            long bodySum = 0;
            long tagSum = 0;
            char[] tag = match.substring(match.lastIndexOf("#") + 1).toCharArray();
            char[] body = match.substring(match.indexOf("#") + tag.length + 1, match.lastIndexOf("#")).toCharArray();
            for (char c : tag) {
                tagSum += c;
            }
            for (char c : body) {
                bodySum += c;
            }
            drinkSum += (bodySum * tagSum);
            validCrates++;
        }
        if(validCrates == 0){
            System.out.println("No supplies found!");
        } else {
            System.out.printf("Number of supply crates: %d%n", validCrates);
            System.out.printf("Amount of food collected: %d%n", foodSum);
            System.out.printf("Amount of drinks collected: %d%n", drinkSum);
        }
    }
}
