package exam_10_07_2016.entities.hardware;

public class PowerHardware extends Hardware{
    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity - ((maximumCapacity * 3) / 4));
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory + ((maximumMemory * 3) / 4));
    }
}
