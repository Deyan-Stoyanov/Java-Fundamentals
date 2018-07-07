package problem5_border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Visitor> allVisitors = new ArrayList<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] visitorData = command.split("\\s+");
            Visitor visitor;
            if(visitorData.length == 2){
                visitor = new Robot(visitorData[0], visitorData[1]);
            } else {
                visitor = new Citizen(visitorData[0], Integer.parseInt(visitorData[1]), visitorData[2]);
            }
            allVisitors.add(visitor);
        }
        String fakeId = reader.readLine();
        for (Visitor v : allVisitors) {
            if(v.getId().endsWith(fakeId)){
                System.out.println(v.getId());
            }
        }
    }
}
