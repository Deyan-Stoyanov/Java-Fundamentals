package problem4_work_force.models;

public class PartTimeEmployee extends BaseEmployee{
    public static final int PART_TIME_WORKING_HOURS_PER_WEEK = 20;

    public PartTimeEmployee(String name) {
        super(name);
        this.setWorkingHoursPerWeek(PART_TIME_WORKING_HOURS_PER_WEEK);
    }
}
