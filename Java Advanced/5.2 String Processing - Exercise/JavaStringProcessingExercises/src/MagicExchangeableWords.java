import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String first = input[0];
        String second = input[1];
        System.out.println(checkString(first, second));
    }

    private static boolean checkString(String first, String second) {
        Set<Character> firstChars = new HashSet<>();
        Set<Character> secondChars = new HashSet<>();
        for (int i = 0; i < first.length(); i++) {
            firstChars.add(first.charAt(i));
        }
        for (int i = 0; i < second.length(); i++) {
            secondChars.add(second.charAt(i));
        }
        if(first.length() == second.length()){
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
                if(map.containsKey(first.charAt(i))){
                    if(!map.get(first.charAt(i)).equals(second.charAt(i))){
                        return false;
                    }
                } else {
                    map.put(first.charAt(i), second.charAt(i));
                }
            }
            return true;
        }
        if(firstChars.size() == secondChars.size()) {
            return true;
        }
        return false;
    }
}
