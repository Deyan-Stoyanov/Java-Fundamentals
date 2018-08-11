package cresla.manager;

import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.factories.ModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImpl() {
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = ReactorFactory.createReactor(arguments.get(1), Integer.parseInt(arguments.get(2)), Integer.parseInt(arguments.get(3)));
        reactors.put(reactor.getId(), reactor);
        return String.format("Created %s Reactor - %d", arguments.get(1), reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        Module module = ModuleFactory.createModule(arguments.get(2), Integer.parseInt(arguments.get(3)));
        if (module instanceof AbsorbingModule) {
            reactors.get(Integer.parseInt(arguments.get(1))).addAbsorbingModule((AbsorbingModule) module);
        } else {
            reactors.get(Integer.parseInt(arguments.get(1))).addEnergyModule((EnergyModule) module);
        }
        this.modules.put(module.getId(), module);
        return String.format("Added %s - %d to Reactor - %d", arguments.get(2), module.getId(), Integer.parseInt(arguments.get(1)));
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int index = Integer.parseInt(arguments.get(1));
        if (this.modules.containsKey(index)) {
            return modules.get(index).toString();
        } else {
            return reactors.get(index).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return String.format("Cryo Reactors: %d%nHeat Reactors: %d%nEnergy Modules: %d%nAbsorbing Modules: %d%nTotal Energy Output: %d%nTotal Heat Absorbing: %d",
                this.reactors.values().stream().filter(x -> x instanceof CryoReactor).count(),
                this.reactors.values().stream().filter(x -> x instanceof HeatReactor).count(),
                this.modules.values().stream().filter(x -> x instanceof EnergyModule).count(),
                this.modules.values().stream().filter(x -> x instanceof AbsorbingModule).count(),
                this.reactors.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum(),
                this.reactors.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum());
    }
}
