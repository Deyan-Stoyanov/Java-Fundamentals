package problem3_mankind;

public class Worker extends Human{
    private Double weekSalary;
    private Double workingHoursPerDay;

    public Worker(String firstName, String lastName, Double weekSalary, Double workingHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkingHoursPerDay(workingHoursPerDay);
    }

    private Double getWeekSalary() {
        return weekSalary;
    }

    private void setWeekSalary(Double weekSalary) {
        if(weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    protected Double getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    private void setWorkingHoursPerDay(Double workingHoursPerDay) {
        if(workingHoursPerDay < 1 || workingHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHoursPerDay = workingHoursPerDay;
    }

    protected Double getSalaryPerHour(){
        return (this.getWeekSalary() / 7) / this.getWorkingHoursPerDay();
    }

    @Override
    public void setLastName(String lastName) {
        if(lastName.length() <= 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",
                this.getFirstName(),
                this.getLastName(),
                this.getWeekSalary(),
                this.getWorkingHoursPerDay(),
                this.getSalaryPerHour()
        );
    }
}
