package problem9_traffic_lights;

public enum TrafficLightColors {
    GREEN(3), YELLOW(1), RED(2);

    private int state;

    TrafficLightColors(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }
}
