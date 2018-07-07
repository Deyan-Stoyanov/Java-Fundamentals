package exam_10_07_2016.entities.hardware;

public class HeavyHardware extends Hardware{
    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity * 2);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory - (maximumMemory / 4));
    }
}
