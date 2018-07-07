package exam_10_07_2016.entities.software;

public abstract class Software {
    private String name;
    private String type;
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, int capacityConsumption, int memoryConsumption) {
        this.setName(name);
        this.setType();
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    protected void setType() {
        this.type = this.getClass().getSimpleName();
    }

    public int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return this.memoryConsumption;
    }

    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
