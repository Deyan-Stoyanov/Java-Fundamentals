package exam_10_07_2016.factories;

import exam_10_07_2016.entities.software.ExpressSoftware;
import exam_10_07_2016.entities.software.LightSoftware;

public final class SoftwareFactory {
    private SoftwareFactory(){  }

    public static ExpressSoftware registerExpressSoftware(String name, int capacity, int memory){
        return new ExpressSoftware(name, capacity, memory);
    }

    public static LightSoftware registerLightSoftware(String name, int capacity, int memory){
        return new LightSoftware(name, capacity, memory);
    }
}
