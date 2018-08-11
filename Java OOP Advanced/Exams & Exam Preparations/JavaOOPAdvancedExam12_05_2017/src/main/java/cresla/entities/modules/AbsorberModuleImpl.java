package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorberModuleImpl extends BaseModule implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbsorberModuleImpl(int heatAbsorbing) {
        super();
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getSpecial() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d%nHeat Absorbing: %d", this.getClass().getSimpleName(), this.getId(), this.getSpecial());
    }
}
