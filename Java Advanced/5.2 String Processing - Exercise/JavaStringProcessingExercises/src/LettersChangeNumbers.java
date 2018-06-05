import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal result = BigDecimal.ZERO;
        String[] input = reader.readLine().split("\\s+");
        for (String s : input) {
            double tempResult = 0;
            char firstLetter = s.charAt(0);
            char lastLetter = s.charAt(s.length() - 1) ;
            double number = Double.parseDouble(s.substring(1, s.length() - 1));
            if(Character.isUpperCase(firstLetter)){
                tempResult = number / (firstLetter - 64);
            } else {
                tempResult = number * (firstLetter - 96);
            }
            if(Character.isUpperCase(lastLetter)){
                tempResult -= (lastLetter - 64);
            } else {
                tempResult += (lastLetter - 96);
            }
            result = result.add(BigDecimal.valueOf(tempResult));
        }
        System.out.printf("%.2f%n", result);
    }
}
