package java_advanced_08_05_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalFlush {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            text.append(reader.readLine()) ;
        }
        Pattern cardPattern  = Pattern.compile("([A-Z]|([0-9]{1,2}))[cdhs]");
        Matcher matcher = cardPattern.matcher(text);
        StringBuilder c = new StringBuilder();
        StringBuilder d = new StringBuilder();
        StringBuilder h = new StringBuilder();
        StringBuilder s = new StringBuilder();

        while(matcher.find()) {
            String card = matcher.group();
            switch (card.substring(card.length() - 1, card.length())){
                case "c":
                    c.append(card);
                    if(c.toString().contains("10cJcQcKcAc")){
                        System.out.println("Royal Flush Found - Clubs");
                        count++;
                        c = new StringBuilder();
                    }
                    break;
                case "d":
                    d.append(card);
                    if(d.toString().contains("10dJdQdKdAd")){
                        System.out.println("Royal Flush Found - Diamonds");
                        count++;
                        d = new StringBuilder();
                    }
                    break;
                case "h":
                    h.append(card);
                    if(h.toString().contains("10hJhQhKhAh")){
                        System.out.println("Royal Flush Found - Hearts");
                        count++;
                        h = new StringBuilder();
                    }
                    break;
                case "s":
                    s.append(card);
                    if(s.toString().contains("10sJsQsKsAs")){
                        System.out.println("Royal Flush Found - Spades");
                        count++;
                        s = new StringBuilder();
                    }
                    break;
            }
        }
        System.out.printf("Royal's Royal Flushes - %d.%n", count);
    }
}
