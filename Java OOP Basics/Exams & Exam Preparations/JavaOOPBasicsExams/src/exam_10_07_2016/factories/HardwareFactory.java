package exam_10_07_2016.factories;

import exam_10_07_2016.entities.hardware.HeavyHardware;
import exam_10_07_2016.entities.hardware.PowerHardware;

public final class HardwareFactory {
    private HardwareFactory(){  }

    public static PowerHardware registerPowerHardware(String name, int capacity, int memory){
        return new PowerHardware(name, capacity, memory);
    }

    public static HeavyHardware registerHeavyHardware(String name, int capacity, int memory){
        return new HeavyHardware(name, capacity, memory);
    }

}
