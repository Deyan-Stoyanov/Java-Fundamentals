package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Modelable;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseVehicle implements Vehicle {
    private String model;
    private double weight;
    private BigDecimal price;
    private long attack;
    private long defence;
    private long hitPoints;
    private Assembler assembler;

    protected BaseVehicle(String model, double weight, BigDecimal price, long attack, long defence, long hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler();
    }

    @Override
    public double getTotalWeight() {
        return this.weight + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defence + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints + this.assembler.getTotalHitPointModification();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        List<Part> parts = new ArrayList<>();
        Field[] fields = this.assembler.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                parts.addAll((List)field.get(this.assembler));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return Collections.unmodifiableCollection(parts);
    }

    private List<Part> partsAsList(){
        List<Part> parts = new ArrayList<>();
        for (Part part : this.getParts()) {
            parts.add(part);
        }
        return parts;
    }

    @Override
    public String toString() {
        return String.format("%s - %s%n" +
                        "Total Weight: %.3f%n" +
                        "Total Price: %.3f%n" +
                        "Attack: %d%n" +
                        "Defense: %d%n" +
                        "HitPoints: %d%n" +
                        "Parts: %s",
                this.getClass().getSimpleName(),
                this.getModel(),
                this.getTotalWeight(),
                this.getTotalPrice(),
                this.getTotalAttack(),
                this.getTotalDefense(),
                this.getTotalHitPoints(),
                this.partsAsList().isEmpty() ? "None" : String.join(", ", this.partsAsList().stream().map(Modelable::getModel).collect(Collectors.toCollection(ArrayList::new))));
    }
}
