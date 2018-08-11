package p01_system_resources;

public class Main {
    public static void main(String[] args) {
        GreetingDevice clock = new GreetingClock(new TimeProviderImpl(), new FileWriter());
        clock.greeting();
    }
}
