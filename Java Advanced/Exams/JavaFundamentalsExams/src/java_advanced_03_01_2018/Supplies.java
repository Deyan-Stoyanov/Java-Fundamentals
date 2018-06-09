package java_advanced_03_01_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Supplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rowsCount = 0;
        Set<String> crates = new HashSet<>();
        Pattern pattern = Pattern.compile("\\[[a-zA-Z0-9#]*]");
        String command;
        while(!"Collect".equalsIgnoreCase(command = reader.readLine())) {
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()){
                crates.add(matcher.group());
            }
            rowsCount++;
        }
        int n = crates.size() / rowsCount;
        crates = crates.stream().filter(x -> x.matches("\\[(#[a-z0-9]{" + n + "}).*\\1]")).collect(Collectors.toCollection(HashSet::new));
        if(crates.isEmpty()){
            System.out.println("No supplies found!");
        } else {
            int foodCount = 0;
            int drinkCount = 0;
            for (String crate : crates) {
                char[] chars = crate.toCharArray();
                Set<Character> uniqueChars = new HashSet<>();
                int tagCount = 0;
                int temp = 0;
                int tagSum = 0;
                int tagIndex = 0;
                if(Character.toString(chars[2]).matches("[a-z]")){
                    for (int i = 2; i < chars.length - 2; i++) {
                        if(Character.isLetter(chars[i]) && Character.isLowerCase(chars[i])){
                            tagSum += chars[i];
                        } else {
                            tagIndex = i;
                            break;
                        }
                    }
                    for (int i = tagIndex; i < chars.length - tagIndex; i++) {
                        temp += (chars[i]);
                    }
                    temp *= tagSum;
                    drinkCount += temp;
                }else if(Character.toString(chars[2]).matches("[0-9]")){
                    for (int i = 2; i < chars.length - 2; i++) {
                        if(Character.isDigit(chars[i])){
                            tagCount++;
                        } else {
                            tagIndex = i;
                            break;
                        }
                    }
                    for (int i = tagIndex; i < chars.length - tagIndex; i++) {
                        uniqueChars.add(chars[i]);
                    }
                    for (Character c : uniqueChars) {
                        temp += c;
                    }
                    temp *= tagCount;
                    foodCount += temp;
                }
            }
            System.out.println("Number of supply crates: " + crates.size());
            System.out.println("Amount of food collected: " + foodCount);
            System.out.println("Amount of drinks collected: " + drinkCount);
        }
    }
}
