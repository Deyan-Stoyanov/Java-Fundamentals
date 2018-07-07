package exam_10_07_2016.entities;

import exam_10_07_2016.entities.hardware.Hardware;
import exam_10_07_2016.entities.software.Software;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dump {
    private Map<String, Hardware> dumpedHardwares;

    public Dump() {
        this.dumpedHardwares = new LinkedHashMap<>();
    }

    public void dumpHardware(Hardware hardware){
        this.dumpedHardwares.putIfAbsent(hardware.getName(), hardware);
    }

    public void destroy(String name){
        this.dumpedHardwares.remove(name);
    }

    public Hardware restore(String name){
        Hardware hardware = dumpedHardwares.get(name);
        dumpedHardwares.remove(name);
        return hardware;
    }

    public Map<String, Hardware> getDumpedHardwares(){
        return Collections.unmodifiableMap(this.dumpedHardwares);
    }

    @Override
    public String toString() {
        return String.format("Dump Analysis%n" +
                "Power Hardware Components: %d%n" +
                "Heavy Hardware Components: %d%n" +
                "Express Software Components: %d%n" +
                "Light Software Components: %d%n" +
                "Total Dumped Memory: %d%n" +
                "Total Dumped Capacity: %d",
                this.dumpedHardwares.values().stream().filter(x -> x.getType().equals("PowerHardware")).count(),
                this.dumpedHardwares.values().stream().filter(x -> x.getType().equals("HeavyHardware")).count(),
                this.dumpedHardwares.values().stream().mapToInt(x -> (int)x.getSoftwares().stream().filter(y -> y.getType().equals("ExpressSoftware")).count()).sum(),
                this.dumpedHardwares.values().stream().mapToInt(x -> (int)x.getSoftwares().stream().filter(y -> y.getType().equals("LightSoftware")).count()).sum(),
                this.dumpedHardwares.values().stream().mapToInt(x -> x.getSoftwares().stream().mapToInt(Software::getMemoryConsumption).sum()).sum(),
                this.dumpedHardwares.values().stream().mapToInt(x -> x.getSoftwares().stream().mapToInt(Software::getCapacityConsumption).sum()).sum());
    }
}
