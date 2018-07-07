package exam_10_07_2016.engine;

import exam_10_07_2016.manager.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    public static final String END_COMMAND = "System Split";
    private Manager manager;
    private BufferedReader reader;
    public Engine() {
        this.manager = new Manager();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        String command;
        while(!END_COMMAND.equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("[\\s(),]+");
            switch (tokens[0]){
                case "RegisterPowerHardware":
                    this.manager.registerPowerHardware(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "RegisterHeavyHardware":
                    this.manager.registerHeavyHardware(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "RegisterExpressSoftware":
                    this.manager.registerExpressSoftware(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                    break;
                case "RegisterLightSoftware":
                    this.manager.registerLightSoftware(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                    break;
                case "ReleaseSoftwareComponent":
                    this.manager.releaseSoftwareComponent(tokens[1], tokens[2]);
                    break;
                case "Analyze":
                    System.out.println(this.manager.analyze());
                    break;
                case "Dump":
                    this.manager.dump(tokens[1]);
                    break;
                case "Restore":
                    this.manager.restore(tokens[1]);
                    break;
                case "Destroy":
                    this.manager.destroy(tokens[1]);
                    break;
                case "DumpAnalyze":
                    System.out.println(this.manager.dumpAnalyze());
                    break;
                default:
                    break;
            }
        }
        System.out.println(this.manager.systemSplit());
    }
}
