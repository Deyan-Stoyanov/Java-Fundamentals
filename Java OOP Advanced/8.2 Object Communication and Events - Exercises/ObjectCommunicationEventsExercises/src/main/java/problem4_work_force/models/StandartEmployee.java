package problem4_work_force.models;

public class StandartEmployee extends BaseEmployee {
    public static final int STANDART_WORKING_HOURS_PER_WEEK = 40;

    public StandartEmployee(String name) {
        super(name);
        this.setWorkingHoursPerWeek(STANDART_WORKING_HOURS_PER_WEEK);
    }
}
