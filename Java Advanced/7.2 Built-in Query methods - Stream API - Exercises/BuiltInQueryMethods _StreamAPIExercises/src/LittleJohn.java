import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder command = new StringBuilder();
        long longArrowsCount = 0;
        long middleArrowsCount = 0;
        long shortArrowsCount = 0;
        for (int i = 0; i < 4; i++) {
            command.append(reader.readLine()).append(" ");
        }
        String endString = command.toString();
        Pattern pattern = Pattern.compile("[>]{3}[\\-]{5}[>]{2}");
        Matcher matcher = pattern.matcher(endString);
        while(matcher.find()) {
            longArrowsCount++;
            endString = endString.replace(matcher.group(), "");
        }
        pattern = Pattern.compile("[>]{2}[\\-]{5}[>]");
        matcher = pattern.matcher(endString);
        while(matcher.find()) {
            middleArrowsCount++;
            endString = endString.replace(matcher.group(), "");
        }
        pattern = Pattern.compile("[>][\\-]{5}[>]");
        matcher = pattern.matcher(endString);
        while(matcher.find()) {
            shortArrowsCount++;
            endString = endString.replace(matcher.group(), "");
        }
        String result = shortArrowsCount + "" + middleArrowsCount + "" + longArrowsCount;
        String bin = Long.toBinaryString(Long.parseLong(result));
        StringBuilder sb = new StringBuilder();
        sb.append(bin);
        for (int j = bin.length() - 1; j >= 0; j--) {
            sb.append(Character.toString(bin.charAt(j)));
        }
        System.out.println(Long.parseLong(sb.toString(), 2));
    }
}
