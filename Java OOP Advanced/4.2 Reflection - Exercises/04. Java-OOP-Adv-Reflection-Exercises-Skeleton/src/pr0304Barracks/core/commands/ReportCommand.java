package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;

public class ReportCommand extends Command{
    @Inject
    private Repository repository;

    public ReportCommand() {
    }

    public ReportCommand(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
