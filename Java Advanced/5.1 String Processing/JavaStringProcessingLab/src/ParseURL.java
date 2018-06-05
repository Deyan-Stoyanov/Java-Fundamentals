import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        boolean invalid = false;
        String protocol = "";
        String server = "";
        String resources = "";
        String[] parts = input.split("://");
        if(input.contains("://")){
            protocol = parts[0];
            input = input.substring(input.indexOf("://") + 3);
        }
        if(input.contains("://")){
            invalid = true;
        }
        server = input.substring(0, input.indexOf("/"));
        if(input.indexOf("/") + 1 < input.length()){
            resources = input.substring(input.indexOf("/") + 1);
        }

        if(invalid){
            System.out.println("Invalid URL");
        } else {
            System.out.printf("Protocol = %s%nServer = %s%nResources = %s%n", protocol, server, resources);
        }
    }
}
