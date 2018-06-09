package java_advanced_08_05_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Royalism {
    private static final Integer POSITION_OF_LETTER_R = 18;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        List<String> royalists = new ArrayList<>();
        List<String> nonRoyalists = new ArrayList<>();
        for (String s : input) {
            long sum = 0;
            for (char c : s.toCharArray()) {
                sum += c;
                while (sum > 26){
                    sum -= 26;
                }
            }
            if(sum == POSITION_OF_LETTER_R){
                royalists.add(s);
            } else {
                nonRoyalists.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(royalists.size() >= nonRoyalists.size()){
            sb.append("Royalists - ").append(royalists.size()).append(System.lineSeparator());
            for (String royalist : royalists) {
                sb.append(royalist).append(System.lineSeparator());
            }
            sb.append("All hail Royal!");
        } else {
            for (String nonRoyalist : nonRoyalists) {
                sb.append(nonRoyalist).append(System.lineSeparator());
            }
            sb.append("Royalism, Declined!");
        }
        System.out.println(sb.toString());
    }
}
