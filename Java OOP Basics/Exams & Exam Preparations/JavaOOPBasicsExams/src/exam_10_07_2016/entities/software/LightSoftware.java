package exam_10_07_2016.entities.software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption + (capacityConsumption / 2));
    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption - (memoryConsumption / 2));
    }
}
