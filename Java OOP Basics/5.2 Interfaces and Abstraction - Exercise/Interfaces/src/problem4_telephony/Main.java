package problem4_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Smartphone smartphone = new Smartphone();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split("\\s+");
        String[] urls = reader.readLine().split("\\s+");
        for (String number : numbers) {
            try {
                smartphone.call(number);
            } catch (IllegalArgumentException ie){
                System.out.println(ie.getMessage());
            }
        }
        for (String url : urls) {
            try {
                smartphone.browse(url);
            }catch (IllegalArgumentException ie){
                System.out.println(ie.getMessage());
            }
        }
    }
}
