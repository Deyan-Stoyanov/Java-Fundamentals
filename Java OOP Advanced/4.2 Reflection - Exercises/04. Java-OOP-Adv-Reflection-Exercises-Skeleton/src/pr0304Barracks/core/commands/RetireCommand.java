package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;

public class RetireCommand extends Command {
    @Inject
    private String data[];
    @Inject
    private Repository repository;

    public RetireCommand() {
    }

    public RetireCommand(String[] data, Repository repository) {
        this.data = data;
        this.repository = repository;
    }

    @Override
    public String execute() {
        try {
            this.repository.removeUnit(data[1]);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException ie){
            return ie.getMessage();
        }
        return data[1] + " retired!";
    }
}
