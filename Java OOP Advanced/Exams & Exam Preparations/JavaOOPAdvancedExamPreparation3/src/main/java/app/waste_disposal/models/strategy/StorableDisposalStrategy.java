package app.waste_disposal.models.strategy;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.processing_data.ProcessingDataImpl;

public class StorableDisposalStrategy implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energyBalance = 0 - (((garbage.getWeight() * garbage.getVolumePerKg()) * 13) / 100);
        double capitalBalance = 0 - (((garbage.getWeight() * garbage.getVolumePerKg()) * 65) / 100);
        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}
