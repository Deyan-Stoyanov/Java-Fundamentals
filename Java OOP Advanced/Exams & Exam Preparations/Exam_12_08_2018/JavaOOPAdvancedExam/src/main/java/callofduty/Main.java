package callofduty;

import callofduty.core.MissionControlImpl;
import callofduty.engine.EngineImpl;
import callofduty.interfaces.*;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;
import callofduty.manager.MissionManagerImpl;


public class Main {
    public static void main(String[] args)  {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        MissionControl control = new MissionControlImpl();
        MissionManager manager = new MissionManagerImpl(control);

        Engine engine = new EngineImpl(reader, writer, manager);
        engine.run();
    }
}




