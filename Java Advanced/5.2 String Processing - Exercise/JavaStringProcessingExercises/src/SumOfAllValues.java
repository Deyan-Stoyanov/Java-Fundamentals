import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyString = reader.readLine();
        String textString  = reader.readLine();
        String startKey = "";
        String endKey = "";
        Pattern pattern = Pattern.compile("^([a-zA-Z_]+)[0-9]+(.*[0-9]+)?([a-zA-Z_]+)$");
        Matcher matcher = pattern.matcher(keyString);
        if(matcher.matches()){
            startKey = matcher.group(1);
            endKey = matcher.group(3);
        }
        if(startKey.isEmpty() || endKey.isEmpty()){
            System.out.println("<p>A key is missing</p>");
        } else {
            BigDecimal sum = sumNumbers(textString, startKey, endKey);
            if(!sum.equals(BigDecimal.ZERO)) {
                if(String.valueOf(sum).matches("[0-9]+(\\.[0]+)?")){
                    System.out.printf("<p>The total value is: <em>%.0f</em></p>%n", sum);
                } else {
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>%n", sum);
                }
            }else {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
        }
    }

    private static BigDecimal sumNumbers(String textString, String startKey, String endKey) {
        Pattern pattern = Pattern.compile(startKey + "[0-9]+(\\.[0-9]+)?" + endKey);
        Matcher matcher = pattern.matcher(textString);
        BigDecimal sum = BigDecimal.ZERO;
        while(matcher.find()) {
            String str = matcher.group();
            double number = Double.parseDouble(str.substring(startKey.length(), str.indexOf(endKey)));
            sum = sum.add(BigDecimal.valueOf(number));
        }
        return sum;
    }
}
