package exam_preparation_1.engine;

import exam_preparation_1.HealthManager;
import exam_preparation_1.io.ConsoleReader;
import exam_preparation_1.io.ConsoleWriter;

import java.io.IOException;

public class Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private HealthManager manager;
    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new HealthManager();
    }
    public void run() throws IOException {
        String command;
        while(!"BEER IS COMING".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            String result = "";
            switch (data[0]){
                case "createOrganism":
                    result = (manager.createOrganism(data[1]));
                    break;
                case "addCluster":
                    result = (manager.addCluster(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                    break;
                case "addCell":
                    result = (manager.addCell(data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8])));
                    break;
                case "activateCluster":
                    result = (manager.activateCluster(data[1]));
                    break;
                case "checkCondition":
                    result = (manager.checkCondition(data[1]));
                    break;
            }
            if(result != null){
                writer.printLine(result);
            }
        }
    }
}
