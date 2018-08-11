package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends BaseWaste {
    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
