package app.waste_disposal.models.management_requirement;

public class ManagementRequirement {
    private double minEnergy;
    private double minCapital;
    private String type;

    public ManagementRequirement(double minEnergy, double minCapital, String type) {
        this.minEnergy = minEnergy;
        this.minCapital = minCapital;
        this.type = type;
    }

    public double getMinEnergy() {
        return this.minEnergy;
    }

    public double getMinCapital() {
        return this.minCapital;
    }

    public String getType() {
        return this.type;
    }
}
