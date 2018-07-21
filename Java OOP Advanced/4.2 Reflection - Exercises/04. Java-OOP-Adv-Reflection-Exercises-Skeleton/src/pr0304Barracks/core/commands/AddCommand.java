package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends Command {
    @Inject
    private String[] data;
    @Inject
    private UnitFactory factory;
    @Inject
    private Repository repository;

    public AddCommand() {
    }

    public AddCommand(String[] data, Repository repository, UnitFactory factory) {
        this.data = data;
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = this.factory.createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
