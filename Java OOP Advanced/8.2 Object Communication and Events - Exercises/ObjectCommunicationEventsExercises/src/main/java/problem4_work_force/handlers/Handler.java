package problem4_work_force.handlers;

import problem4_work_force.models.Job;

public class Handler {
    public void handleEvent(Job job){
        System.out.printf("Job %s done!%n", job.getName());
    }
}
