import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            sb.append(command).append(System.lineSeparator());
        }
        String text = sb.toString();
        while (text.contains("<a") && text.contains("</a>")){
            String strToReplace = text.substring(sb.indexOf("<a"), text.indexOf("</a>") + 4);
            String newString = strToReplace;
            newString = newString.replace("<a", "[URL");
            newString = newString.replace("</a>", "[/URL]");
            newString = newString.replace(">", "]");
            text = text.replace(strToReplace, newString);
        }
        System.out.println(text);
    }
}
