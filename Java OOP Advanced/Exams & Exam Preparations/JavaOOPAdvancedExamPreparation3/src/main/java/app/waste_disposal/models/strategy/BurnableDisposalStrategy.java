package app.waste_disposal.models.strategy;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.processing_data.ProcessingDataImpl;

public class BurnableDisposalStrategy implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = (garbage.getWeight() * garbage.getVolumePerKg()) - (((garbage.getWeight() * garbage.getVolumePerKg()) * 20) / 100);
        double capitalBalance = 0;
        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}
