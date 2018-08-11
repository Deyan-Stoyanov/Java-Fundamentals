package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CryoReactor extends BaseReactor{
    private int cryoProductionIndex;

    public CryoReactor(int cryoProductionIndex, int capacity) {
        super(capacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public int getIndex() {
        return this.cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        if(this.getTotalHeatAbsorbing() < this.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex){
            return 0;
        }
        return this.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.getContainer().getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        int count = 0;
        for (Field field : this.getContainer().getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(field.getName().equals("absorbingModules") || field.getName().equals("energyModules")){
                try {
                    count += ((Map)field.get(this.getContainer())).size();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.getContainer().addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.getContainer().addAbsorbingModule(absorbingModule);
    }

    @Override
    public String toString() {
        return String.format("%s - %d%nEnergy Output: %d%nHeat Absorbing: %d%nModules: %d", this.getClass().getSimpleName(), this.getId(), this.getTotalEnergyOutput(), this.getTotalHeatAbsorbing(), this.getModuleCount());
    }
}
