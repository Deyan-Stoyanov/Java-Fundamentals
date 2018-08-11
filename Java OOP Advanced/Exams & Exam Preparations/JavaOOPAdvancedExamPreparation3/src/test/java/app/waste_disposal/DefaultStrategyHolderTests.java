package app.waste_disposal;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultStrategyHolderTests {
    StrategyHolder strategyHolder;
    @Before
    public void init(){
        strategyHolder = new DefaultStrategyHolder();
    }

    @Test
    public void addStrategyAddsStrategy(){
        GarbageDisposalStrategy mockStrategy = Mockito.mock(GarbageDisposalStrategy.class);
        strategyHolder.addStrategy(GarbageDisposalStrategy.class, mockStrategy);
        Assert.assertEquals(4, strategyHolder.getDisposalStrategies().size());
    }

    @Test
    public void removeStrategyRemovesStrategy(){
        GarbageDisposalStrategy firstMockStrategy = Mockito.mock(GarbageDisposalStrategy.class);
        strategyHolder.addStrategy(GarbageDisposalStrategy.class, firstMockStrategy);
        strategyHolder.removeStrategy(GarbageDisposalStrategy.class);
        Assert.assertEquals(3, strategyHolder.getDisposalStrategies().size());
    }

    @Test public void getDisposalStrategiesReturnsLinkedHashMapOfStrategies(){
        Assert.assertEquals("UnmodifiableMap", strategyHolder.getDisposalStrategies().getClass().getSimpleName());
        Assert.assertEquals(3, strategyHolder.getDisposalStrategies().size());
    }
}
