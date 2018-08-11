package panzer.manager;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.factory.PartFactory;
import panzer.factory.VehicleFactory;
import panzer.util.Config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class PanzerManager implements Manager {
    private Map<String, Vehicle> vehicles;
    private Map<String, Part> parts;
    private List<String> defeatedVehicles;
    private BattleOperator battleOperator;

    public PanzerManager(BattleOperator battleOperator) {
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        this.defeatedVehicles = new ArrayList<>();
        this.battleOperator = battleOperator;
    }

    @Override
    public String addVehicle(List<String> arguments) {
        Vehicle vehicle = null;
        try {
            vehicle = VehicleFactory.createVehicle(arguments.get(1), arguments.get(2), Double.parseDouble(arguments.get(3)), new BigDecimal(arguments.get(4)), Long.parseLong(arguments.get(5)), Long.parseLong(arguments.get(6)), Long.parseLong(arguments.get(7)));
            this.vehicles.put(vehicle.getModel(), vehicle);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return String.format(Config.CREATE_VEHICLE_MESSAGE, vehicle.getClass().getSimpleName(), vehicle.getModel());
    }

    @Override
    public String addPart(List<String> arguments) {
        Part part = null;
        String panzerModel = arguments.get(1);
        try {
            part = PartFactory.createPart(arguments.get(2), arguments.get(3), Double.parseDouble(arguments.get(4)), new BigDecimal(arguments.get(5)), Integer.parseInt(arguments.get(6)));
            String methodName = "add" + part.getClass().getSimpleName();
            Method method = this.vehicles.get(panzerModel).getClass().getSuperclass().getDeclaredMethod(methodName, Part.class);
            method.setAccessible(true);
            method.invoke(this.vehicles.get(panzerModel), (Object)part);
            this.parts.put(part.getModel(), part);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return String.format(Config.CREATE_PART_MESSAGE, part.getClass().getSimpleName().substring(0, part.getClass().getSimpleName().indexOf("Part")), part.getModel(), panzerModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(1);
        if(this.vehicles.containsKey(model)){
            return this.vehicles.get(model).toString();
        } else {
            return this.parts.get(model).toString();
        }
    }

    @Override
    public String battle(List<String> arguments) {
        String firstModel = arguments.get(1);
        String secondModel = arguments.get(2);
        String winner =  this.battleOperator.battle(this.vehicles.get(firstModel), this.vehicles.get(secondModel));
        String loser;
        if(winner.equalsIgnoreCase(firstModel)){
            loser = secondModel;
        } else {
            loser = firstModel;
        }
        this.defeatedVehicles.add(loser);
        return String.format(Config.BATTLE_MESSAGE, firstModel, secondModel, winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        return String.format("Remaining Vehicles: %s%n" +
                "Defeated Vehicles: %s%n" +
                "Currently Used Parts: %d",
                this.defeatedVehicles.containsAll(this.vehicles.keySet()) ? "None" :  String.join(", ", this.vehicles.keySet().stream().filter(x -> !(this.defeatedVehicles.contains(x))).collect(Collectors.toCollection(ArrayList::new))),
                this.defeatedVehicles.isEmpty() ? "None" : String.join(", ", this.defeatedVehicles),
                this.vehicles.entrySet().stream().filter(x -> !(this.defeatedVehicles.contains(x.getKey()))).mapToLong(x -> {
                    AtomicLong totalParts = new AtomicLong();
                    x.getValue().getParts().forEach(y -> totalParts.addAndGet(1));
                    return totalParts.get();
                }).sum());
    }
}
