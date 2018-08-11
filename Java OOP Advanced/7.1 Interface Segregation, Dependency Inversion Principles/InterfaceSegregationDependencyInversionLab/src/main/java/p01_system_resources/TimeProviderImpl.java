package p01_system_resources;

import java.time.LocalTime;

public class TimeProviderImpl implements TimeProvider {
    @Override
    public int getCurrentTime() {
        return LocalTime.now().getHour();
    }
}
