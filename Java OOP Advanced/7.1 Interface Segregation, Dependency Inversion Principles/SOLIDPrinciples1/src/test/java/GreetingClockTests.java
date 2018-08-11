import org.junit.Test;
import org.mockito.Mockito;
import p01_system_resources.*;

public class GreetingClockTests {

    @Test
    public void testMorningGreeting(){
        TimeProvider mockTime = Mockito.mock(TimeProviderImpl.class);
        Mockito.when(mockTime.getCurrentTime()).thenReturn(8);
        Writer mockWriter = Mockito.mock(ConsoleWriter.class);
//        GreetingDevice clock = new GreetingClock(mockTime, Mockito.any(ConsoleWriter.class));
        GreetingDevice clock = new GreetingClock(mockTime, mockWriter);
        clock.greeting();
//        Mockito.verify(writer).writeLine("Good morning...");
        Mockito.verify(mockWriter, Mockito.times(1)).writeLine("Good morning...");
    }
}
