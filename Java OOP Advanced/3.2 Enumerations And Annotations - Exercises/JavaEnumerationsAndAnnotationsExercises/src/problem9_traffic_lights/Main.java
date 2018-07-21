package problem9_traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] colors = reader.readLine().split("\\s+");
        TrafficLightColors[] trafficLight = new TrafficLightColors[colors.length];
        for (int i = 0; i < trafficLight.length; i++) {
            trafficLight[i] = Enum.valueOf(TrafficLightColors.class, colors[i]);
        }
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            changeStates(trafficLight);
        }
    }

    public static int getCurrentState(String color) {
        switch (color) {
            case "GREEN":
                return 1;
            case "YELLOW":
                return 2;
            case "RED":
                return 3;
        }
        return 0;
    }

    public static void changeStates(TrafficLightColors[] trafficLight) {
        for (int i = 0; i < trafficLight.length; i++) {
            int newState = getCurrentState(trafficLight[i].name());
            trafficLight[i] = Arrays.stream(TrafficLightColors.values()).filter(x -> x.getState() == newState).findFirst().get();
            System.out.print(trafficLight[i].name() + " ");
        }
        System.out.println();
    }
}
