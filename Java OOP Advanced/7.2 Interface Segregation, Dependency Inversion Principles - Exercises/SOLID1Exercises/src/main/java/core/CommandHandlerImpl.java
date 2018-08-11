package core;

import utility.Constants;
import contracts.BoatSimulatorController;
import contracts.CommandHandler;
import controllers.BoatSimulatorControllerImpl;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;

import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    public BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.setController(controller);
    }

    public CommandHandlerImpl() {
        this.setController(new BoatSimulatorControllerImpl(new BoatSimulatorDatabase(), null));
    }

    public BoatSimulatorController getController() {
        return this.controller;
    }

    private void setController(BoatSimulatorController controller) {
        this.controller = controller;
    }

    public String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                if (parameters.get(3).equals("Jet")) {
                    return this.getController().createBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            String.valueOf(EngineType.JET));
                } else if (parameters.get(3).equals("Sterndrive")) {
                    return this.getController().createBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            String.valueOf(EngineType.STERNDRIVE));
                }
                throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);

            case "CreateRowBoat":
                return this.getController().createRowBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreateSailBoat":
                return this.getController().createSailBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreatePowerBoat":
                return this.getController().createPowerBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        parameters.get(3));
            case "CreateYacht":
                return this.getController().createYacht(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        Integer.parseInt(parameters.get(3)));
            case "OpenRace":
                return this.getController().openRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));
            case "SignUpBoat":
                return this.getController().signUpBoat(parameters.get(0));
            case "StartRace":
                return this.getController().startRace();
            case "GetStatistic":
                return this.getController().getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
