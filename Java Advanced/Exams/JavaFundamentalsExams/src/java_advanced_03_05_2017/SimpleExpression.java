package java_advanced_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String digits = reader.readLine();
        Pattern numberPattern = Pattern.compile("[+\\-]?[0-9]+([.][0-9]+)?");
        Pattern signPattern = Pattern.compile("[^0-9.+\\-]+");
        Matcher numberMatcher = numberPattern.matcher(digits);
        Matcher signMatcher = signPattern.matcher(digits);
        BigDecimal result = BigDecimal.ZERO;
        if(numberMatcher.find()){
            result = result.add(new BigDecimal(numberMatcher.group()));
        }
        while (numberMatcher.find() && signMatcher.find()){
            String signString = signMatcher.group();
            String numberString = numberMatcher.group();
            if(signString.length() % 2 == 0){
                result = result.add(new BigDecimal((numberString)));
            } else {
                result = result.subtract(new BigDecimal((numberString)));
            }
        }
        System.out.println(new DecimalFormat("#.#######").format(result));
    }
}
