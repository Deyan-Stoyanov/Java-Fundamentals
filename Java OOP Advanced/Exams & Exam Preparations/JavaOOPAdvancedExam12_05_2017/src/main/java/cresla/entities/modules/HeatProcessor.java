package cresla.entities.modules;

public class HeatProcessor extends AbsorberModuleImpl {

    public HeatProcessor(int heatAbsorbing) {
        super(heatAbsorbing);
    }

    @Override
    public int getHeatAbsorbing() {
        return super.getSpecial();
    }
}
