package app.waste_disposal;

import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultGarbageProcessorTests {
    GarbageProcessor processor;

    @Before
    public void init(){
        processor = new DefaultGarbageProcessor();
    }

    @Test
    public void getStrategyHolderReturnsStrategyHolder(){
        Assert.assertEquals("DefaultStrategyHolder", processor.getStrategyHolder().getClass().getSimpleName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void processWasteReturnsCorrectProcessingData(){
        Waste mockWaste = Mockito.mock(Waste.class);
        Mockito.when(mockWaste.getName()).thenReturn("Glass");
        Mockito.when(mockWaste.getWeight()).thenReturn(1D);
        Mockito.when(mockWaste.getVolumePerKg()).thenReturn(1D);
        ProcessingData data = processor.processWaste(mockWaste);
        Assert.assertEquals(400, data.getCapitalBalance(), 0.0005);
        Assert.assertEquals(-0.5, data.getEnergyBalance(), 0.0005);
    }
}
