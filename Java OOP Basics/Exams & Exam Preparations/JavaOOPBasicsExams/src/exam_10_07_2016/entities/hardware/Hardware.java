package exam_10_07_2016.entities.hardware;

import exam_10_07_2016.entities.software.Software;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Hardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> softwares;

    public Hardware(String name, int maximumCapacity, int maximumMemory) {
        this.setName(name);
        this.setType();
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softwares = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    protected void setType() {
        this.type = this.getClass().getSimpleName();
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public List<Software> getSoftwares() {
        return Collections.unmodifiableList(this.softwares);
    }

    protected void setSoftwares(List<Software> softwares) {
        this.softwares = softwares;
    }

    public void addSoftware(Software software){
        if(((this.softwares.stream().mapToInt(Software::getCapacityConsumption).sum() + software.getCapacityConsumption()) <= this.getMaximumCapacity()) && ((this.softwares.stream().mapToInt(Software::getMemoryConsumption).sum() + software.getMemoryConsumption()) <= this.getMaximumMemory())){
            this.softwares.add(software);
        }
    }

    public void removeSoftware(String softwareName){
        this.softwares.removeIf(x -> x.getName().equalsIgnoreCase(softwareName));
    }

    @Override
        public String toString() {
            return String.format("Hardware Component - %s%n" +
                    "Express Software Components - %d%n" +
                    "Light Software Components - %d%n" +
                    "Memory Usage: %d / %d%n" +
                    "Capacity Usage: %d / %d%n" +
                    "Type: %s%n" +
                    "Software Components: %s",
                    this.getName(),
                    this.softwares.stream().filter(x -> x.getType().equalsIgnoreCase("ExpressSoftware")).count(),
                    this.softwares.stream().filter(x -> x.getType().equalsIgnoreCase("LightSoftware")).count(),
                    this.softwares.stream().mapToInt(Software::getMemoryConsumption).sum(),
                    this.getMaximumMemory(),
                    this.softwares.stream().mapToInt(Software::getCapacityConsumption).sum(),
                    this.getMaximumCapacity(),
                    this.getType().substring(0, this.getType().indexOf("Hardware")),
                    this.softwares.isEmpty() ? "None" : String.join(", ", this.getSoftwares().stream().map(Software::getName).collect(Collectors.toList())));
        }
}
