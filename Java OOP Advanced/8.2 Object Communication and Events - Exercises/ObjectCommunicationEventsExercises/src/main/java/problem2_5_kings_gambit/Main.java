package problem2_5_kings_gambit;

import problem2_5_kings_gambit.abstractions.Command;
import problem2_5_kings_gambit.commands.AttackCommand;
import problem2_5_kings_gambit.commands.CommandExecutor;
import problem2_5_kings_gambit.commands.KillCommand;
import problem2_5_kings_gambit.factories.KingFactory;
import problem2_5_kings_gambit.models.King;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        King king = KingFactory.createKing(reader.readLine());
        String[] royalGuardsNames = reader.readLine().split("\\s+");
        for (String royalGuardsName : royalGuardsNames) {
            king.addRoyalGuard(royalGuardsName);
        }
        String[] footmanNames = reader.readLine().split("\\s+");
        for (String footmanName : footmanNames) {
            king.addFootman(footmanName);
        }
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("\\s+");
            Command commandToExecute = null;
            switch (tokens[0]){
                case "Kill":
                    commandToExecute = new KillCommand(king, tokens[1]);
                    break;
                case "Attack":
                    commandToExecute = new AttackCommand(king);
            }
            if (commandToExecute != null) {
                CommandExecutor.executeCommand(commandToExecute);
            }
        }
    }
}
