package app.waste_disposal;

import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.annotations.Storable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.models.strategy.BurnableDisposalStrategy;
import app.waste_disposal.models.strategy.RecyclableDisposalStrategy;
import app.waste_disposal.models.strategy.StorableDisposalStrategy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private LinkedHashMap<Class,GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder(){
        this.strategies = new LinkedHashMap<>(){{
            put(Burnable.class, new BurnableDisposalStrategy());
            put(Storable.class, new StorableDisposalStrategy());
            put(Recyclable.class, new RecyclableDisposalStrategy());
        }};
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        this.strategies.put(annotationClass,strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        this.strategies.remove(annotationClass);
        return true;
    }
}
