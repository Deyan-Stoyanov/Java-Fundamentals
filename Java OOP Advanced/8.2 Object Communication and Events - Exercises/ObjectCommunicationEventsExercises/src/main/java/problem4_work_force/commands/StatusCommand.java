package problem4_work_force.commands;

import problem4_work_force.abstractions.Command;
import problem4_work_force.models.Job;

import java.util.Map;

public class StatusCommand implements Command {
    private Map<String, Job> jobs;

    public StatusCommand(Map<String, Job> jobs) {
        this.jobs = jobs;
    }


    @Override
    public void execute() {
        this.jobs.values().stream().filter(x -> !x.isDone()).forEach(System.out::println);
    }
}

