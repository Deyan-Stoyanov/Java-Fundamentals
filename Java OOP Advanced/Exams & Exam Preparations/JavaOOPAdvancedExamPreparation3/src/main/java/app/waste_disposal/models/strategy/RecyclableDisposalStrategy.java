package app.waste_disposal.models.strategy;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.processing_data.ProcessingDataImpl;

public class RecyclableDisposalStrategy implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = 0 - (((garbage.getWeight() * garbage.getVolumePerKg()) * 50) / 100);
        double capitalBalance = 400 * garbage.getWeight();
        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}
