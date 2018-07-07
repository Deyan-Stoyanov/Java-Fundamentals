package problem8_military_elite.units;

public class Repair {
    private String partName;
    private Integer hoursWorked;

    public Repair() {
    }

    public Repair(String partName, Integer hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    public String getPartName() {
        return partName;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.getHoursWorked());
    }
}
