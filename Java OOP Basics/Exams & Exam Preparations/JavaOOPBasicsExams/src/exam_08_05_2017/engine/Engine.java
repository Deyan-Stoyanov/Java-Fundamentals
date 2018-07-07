package exam_08_05_2017.engine;

import exam_08_05_2017.AvatarManager;
import exam_08_05_2017.io.ConsoleReader;
import exam_08_05_2017.io.ConsoleWriter;

import java.io.IOException;

public class Engine {

    private AvatarManager manager;
    private ConsoleReader reader;
    private ConsoleWriter writer;

    private static final String FINAL_COMMAND = "Quit";

    public Engine() {
        this.manager = new AvatarManager();
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
    }

    public void run() throws IOException {
        String command;
        while (!FINAL_COMMAND.equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Bender":
                    this.manager.addBender(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]));
                    break;
                case "Monument":
                    this.manager.addMonument(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                    break;
                case "Status":
                    String currentNationStatus = this.manager.status(tokens[1]);
                    if (currentNationStatus != null) {
                        this.writer.printLine(this.manager.status(tokens[1]));
                    }
                    break;
                case "War":
                    this.manager.war(tokens[1]);
                    break;
                default:
                    break;
            }
        }
        this.manager.getWars()
                .forEach((key, value) -> this.writer.printLine(String.format("War %d issued by %s", key, value)));
    }
}
