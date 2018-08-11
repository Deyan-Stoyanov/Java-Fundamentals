package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class EnergyModuleImpl extends BaseModule implements EnergyModule {
    private int energyOutput;

    protected EnergyModuleImpl(int energyOutput) {
        super();
        this.energyOutput = energyOutput;
    }

    @Override
    public int getSpecial() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d%nEnergy Output: %d", this.getClass().getSimpleName(), this.getId(), this.getSpecial());
    }
}
