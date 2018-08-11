package cresla.entities.modules;

public class CryogenRod extends EnergyModuleImpl {

    public CryogenRod(int energyOutput) {
        super(energyOutput);
    }

    @Override
    public int getEnergyOutput() {
        return super.getSpecial();
    }
}
