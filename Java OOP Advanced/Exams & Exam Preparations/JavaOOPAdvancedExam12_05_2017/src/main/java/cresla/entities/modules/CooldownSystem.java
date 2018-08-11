package cresla.entities.modules;

public class CooldownSystem extends AbsorberModuleImpl {

    public CooldownSystem(int heatAbsorbing) {
        super(heatAbsorbing);
    }

    @Override
    public int getHeatAbsorbing() {
        return super.getSpecial();
    }
}
