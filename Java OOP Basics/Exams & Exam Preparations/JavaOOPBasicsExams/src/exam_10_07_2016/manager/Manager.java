package exam_10_07_2016.manager;

import exam_10_07_2016.entities.Dump;
import exam_10_07_2016.entities.hardware.Hardware;
import exam_10_07_2016.entities.hardware.HeavyHardware;
import exam_10_07_2016.entities.hardware.PowerHardware;
import exam_10_07_2016.entities.software.Software;
import exam_10_07_2016.factories.HardwareFactory;
import exam_10_07_2016.factories.SoftwareFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Manager {

    private Map<String, Hardware> hardwares;
    private Dump dump;

    public Manager() {
        this.hardwares = new LinkedHashMap<>();
        dump = new Dump();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        PowerHardware powerHardware = HardwareFactory.registerPowerHardware(name, capacity, memory);
        this.hardwares.put(powerHardware.getName(), powerHardware);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HeavyHardware heavyHardware = HardwareFactory.registerHeavyHardware(name, capacity, memory);
        this.hardwares.put(heavyHardware.getName(), heavyHardware);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory){
        if(this.hardwares.containsKey(hardwareComponentName)){
            this.hardwares.get(hardwareComponentName).addSoftware(SoftwareFactory.registerExpressSoftware(name, capacity, memory));
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory){
        if(this.hardwares.containsKey(hardwareComponentName)){
            this.hardwares.get(hardwareComponentName).addSoftware(SoftwareFactory.registerLightSoftware(name, capacity, memory));
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName){
        if(this.hardwares.containsKey(hardwareComponentName)){
            this.hardwares.get(hardwareComponentName).removeSoftware(softwareComponentName);
        }
    }

    public String analyze(){
        int totalMemory = this.hardwares.values().stream().mapToInt(Hardware::getMaximumMemory).sum();
        int totalTakenMemory = this.hardwares.values().stream().mapToInt(x -> x.getSoftwares().stream().mapToInt(Software::getMemoryConsumption).sum()).sum();
        int totalCapacity = this.hardwares.values().stream().mapToInt(Hardware::getMaximumCapacity).sum();
        int totalTakenCapacity = this.hardwares.values().stream().mapToInt(x -> x.getSoftwares().stream().mapToInt(Software::getCapacityConsumption).sum()).sum();
        return String.format("System Analysis%n" +
                "Hardware Components: %d%n" +
                "Software Components: %d%n" +
                "Total Operational Memory: %d / %d%n" +
                "Total Capacity Taken: %d / %d", this.hardwares.size(), this.hardwares.values().stream().mapToInt(x -> x.getSoftwares().size()).sum(), totalTakenMemory, totalMemory, totalTakenCapacity, totalCapacity);
    }

    public String systemSplit(){
        StringBuilder sb = new StringBuilder();
        this.hardwares.values().forEach(x -> sb.append(x.toString()).append(System.lineSeparator()));
        return sb.toString();
    }

    public void dump(String hardwareComponentName){
        if(this.hardwares.containsKey(hardwareComponentName)){
            this.dump.dumpHardware(this.hardwares.remove(hardwareComponentName));
        }
    }

    public void restore(String hardwareComponentName){
        if(this.dump.getDumpedHardwares().containsKey(hardwareComponentName)){
            Hardware hardware = this.dump.restore(hardwareComponentName);
            this.hardwares.put(hardwareComponentName, hardware);
        }
    }

    public void destroy(String hardwareComponentName){
        if(this.dump.getDumpedHardwares().containsKey(hardwareComponentName)) {
            this.dump.destroy(hardwareComponentName);
        }
    }

    public String dumpAnalyze(){
        return this.dump.toString();
    }
}
