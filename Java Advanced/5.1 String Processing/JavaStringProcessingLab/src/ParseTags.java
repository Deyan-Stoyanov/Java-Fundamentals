import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        while (text.contains("<upcase>") && text.contains("</upcase>")){
            if(!text.substring(text.indexOf("<upcase>") + 8, text.indexOf("</upcase>")).isEmpty()){
                text = text.replace(text.substring(text.indexOf("<upcase>"), text.indexOf("</upcase>") + 9), text.substring(text.indexOf("<upcase>") + 8, text.indexOf("</upcase>")).toUpperCase());
            }
        }
        System.out.println(text);
    }
}
