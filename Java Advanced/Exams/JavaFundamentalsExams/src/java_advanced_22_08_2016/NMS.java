package java_advanced_22_08_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String command;
        while(!"---NMS SEND---".equalsIgnoreCase(command = reader.readLine())) {
            sb.append(command.trim());
        }
        command = sb.toString();
        String delimiter = reader.readLine();
        sb = new StringBuilder();
        sb.append(command.charAt(0));
        for (int i = 1; i < command.length(); i++) {
            if(command.toLowerCase().charAt(i) < command.toLowerCase().charAt(i - 1)){
                sb.append(delimiter);
            }
            sb.append(command.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
