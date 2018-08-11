package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTests {
    private VehicleAssembler vehicleAssembler;

    @Before
    public void init(){
        this.vehicleAssembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        DefenseModifyingPart part3 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part4 = Mockito.mock(DefenseModifyingPart.class);
        HitPointsModifyingPart part5 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part6 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part1.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(part2.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(part3.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(part4.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(part5.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(part6.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(part1.getWeight()).thenReturn(50D);
        Mockito.when(part2.getWeight()).thenReturn(50D);
        Mockito.when(part3.getWeight()).thenReturn(50D);
        Mockito.when(part4.getWeight()).thenReturn(50D);
        Mockito.when(part5.getWeight()).thenReturn(50D);
        Mockito.when(part6.getWeight()).thenReturn(50D);
        Mockito.when(part1.getAttackModifier()).thenReturn(5);
        Mockito.when(part2.getAttackModifier()).thenReturn(5);
        Mockito.when(part3.getDefenseModifier()).thenReturn(15);
        Mockito.when(part4.getDefenseModifier()).thenReturn(15);
        Mockito.when(part5.getHitPointsModifier()).thenReturn(20);
        Mockito.when(part6.getHitPointsModifier()).thenReturn(20);
        this.vehicleAssembler.addArsenalPart(part1);
        this.vehicleAssembler.addArsenalPart(part2);
        this.vehicleAssembler.addShellPart(part3);
        this.vehicleAssembler.addShellPart(part4);
        this.vehicleAssembler.addEndurancePart(part5);
        this.vehicleAssembler.addEndurancePart(part6);
    }

    @Test
    public void addingPartsReturnsTotalPrice(){
        Assert.assertEquals(new BigDecimal(60), this.vehicleAssembler.getTotalPrice());
    }

    @Test
    public void addingPartsReturnsTotalWeight(){
        Assert.assertEquals( 300D, this.vehicleAssembler.getTotalWeight(), 0.005);
    }

    @Test
    public void addingPartsReturnsTotalAttackModifier(){
        Assert.assertEquals( 10, this.vehicleAssembler.getTotalAttackModification());
    }

    @Test
    public void addingPartsReturnsTotalDefenceModifier(){
        Assert.assertEquals( 30, this.vehicleAssembler.getTotalDefenseModification());
    }

    @Test
    public void addingPartsReturnsTotalHitPointsModifier(){
        Assert.assertEquals( 40, this.vehicleAssembler.getTotalHitPointModification());
    }

    @Test
    public void addingArsenalPartsIncreasesListSize() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.vehicleAssembler.getClass().getDeclaredField("arsenalParts");
        field.setAccessible(true);
        Assert.assertEquals( 2, ((List)(field.get(this.vehicleAssembler))).size());
    }

    @Test
    public void addingShellPartsIncreasesListSize() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.vehicleAssembler.getClass().getDeclaredField("shellParts");
        field.setAccessible(true);
        Assert.assertEquals( 2, ((List)(field.get(this.vehicleAssembler))).size());
    }

    @Test
    public void addingEndurancePartsIncreasesListSize() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.vehicleAssembler.getClass().getDeclaredField("enduranceParts");
        field.setAccessible(true);
        Assert.assertEquals( 2, ((List)(field.get(this.vehicleAssembler))).size());
    }
}
