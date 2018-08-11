package app.engine;

import app.contracts.*;
import app.util.Config;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Reader reader;
    private Writer writer;
    private Battlefield battleField;

    public EngineImpl(Reader reader, Writer writer, Battlefield battleField) {
        this.reader = reader;
        this.writer = writer;
        this.battleField = battleField;
    }

    @Override
    public void run() throws IOException {
        String line;
        while (!Config.END_COMMAND.equalsIgnoreCase(line = reader.readLine())) {
            String[] lineTokens = line.split("\\s+");
            switch (lineTokens[0]) {
                case Config.CREATE_PARTICIPANT_COMMAND:
                    battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case Config.CREATE_ACTION_COMMAND:
                    battleField.createAction(lineTokens[1],
                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                    Arrays.stream(lineTokens).skip(2).toArray().length,
                                    String[].class));
                    break;
                case Config.STAT_PARTICIPANT_COMMAND:
                    battleField.reportParticipants();
                    break;
                case Config.STAT_ACTION_COMMAND:
                    battleField.reportActions();
                    break;
                case Config.CREATE_SPECIAL_COMMAND:
                    battleField.createSpecial(lineTokens[1], lineTokens[2]);
                    break;
                default:
                    writer.writeLine(Config.INVALID_COMMAND_MESSAGE);
                    break;
            }
        }
    }
}
