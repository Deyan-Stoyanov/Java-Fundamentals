package problem6_custom_enum_annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String className = reader.readLine();
        Annotation annotation = null;
        switch (className){
            case "Rank":
                annotation = CardRank.class.getAnnotation(CustomAnnotation.class);
                break;
            case "Suit":
                annotation = CardSuit.class.getAnnotation(CustomAnnotation.class);
                break;
                default:break;
        }
        if(annotation != null){
            System.out.printf("Type = %s, Description = %s%n", ((CustomAnnotation) annotation).type(), ((CustomAnnotation) annotation).description());
        }
    }
}
