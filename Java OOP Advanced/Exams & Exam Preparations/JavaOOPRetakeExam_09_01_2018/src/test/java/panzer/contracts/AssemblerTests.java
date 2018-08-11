package panzer.contracts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class AssemblerTests {
    private Assembler assembler;
    @Before
    public void init(){
        this.assembler = new VehicleAssembler();

        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);

        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(1);
        Mockito.when(attackModifyingPart.getPrice()).thenReturn(BigDecimal.valueOf(10));
        Mockito.when(attackModifyingPart.getWeight()).thenReturn(5D);
        Mockito.when(attackModifyingPart.getModel()).thenReturn("Attack");

        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(1);
        Mockito.when(defenseModifyingPart.getPrice()).thenReturn(BigDecimal.valueOf(10));
        Mockito.when(defenseModifyingPart.getWeight()).thenReturn(5D);
        Mockito.when(defenseModifyingPart.getModel()).thenReturn("Defence");

        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(1);
        Mockito.when(hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.valueOf(10));
        Mockito.when(hitPointsModifyingPart.getWeight()).thenReturn(5D);
        Mockito.when(hitPointsModifyingPart.getModel()).thenReturn("HitPoints");

        this.assembler.addArsenalPart(attackModifyingPart);
        this.assembler.addShellPart(defenseModifyingPart);
        this.assembler.addEndurancePart(hitPointsModifyingPart);
    }

    @Test
    public void addArsenalPartAddsPart() throws NoSuchFieldException, IllegalAccessException {
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(attackModifyingPart);
        Field field = this.assembler.getClass().getDeclaredField("arsenalParts");
        field.setAccessible(true);
        Assert.assertEquals(2, ((List)field.get(this.assembler)).size());
    }

    @Test
    public void addShellPartAddsPart() throws NoSuchFieldException, IllegalAccessException {
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(defenseModifyingPart);
        Field field = this.assembler.getClass().getDeclaredField("shellParts");
        field.setAccessible(true);
        Assert.assertEquals(2, ((List)field.get(this.assembler)).size());
    }

    @Test
    public void addEndurancePartAddsPart() throws NoSuchFieldException, IllegalAccessException {
        HitPointsModifyingPart endurancePart = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(endurancePart);
        Field field = this.assembler.getClass().getDeclaredField("enduranceParts");
        field.setAccessible(true);
        Assert.assertEquals(2, ((List)field.get(this.assembler)).size());
    }

    @Test
    public void getTotalPriceReturnsPriceOfAll(){
        Assert.assertEquals(new BigDecimal(30), this.assembler.getTotalPrice());
    }

    @Test
    public void getTotalWeightReturnsWeightOfAll(){
        Assert.assertEquals(15, this.assembler.getTotalWeight(), 0.001);
    }

    @Test
    public void getTotalAttackModificationReturnsAttackModification() {
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(2);
        this.assembler.addArsenalPart(attackModifyingPart);
        Assert.assertEquals(3, this.assembler.getTotalAttackModification());
    }

    @Test
    public void getTotalDefenseModificationReturnsDefenseModification(){
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(4);
        this.assembler.addShellPart(defenseModifyingPart);
        Assert.assertEquals(5, this.assembler.getTotalDefenseModification());
    }

    @Test
    public void getTotalHitPointsModificationReturnsHitPointsModification(){
        HitPointsModifyingPart endurancePart = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(endurancePart.getHitPointsModifier()).thenReturn(6);
        this.assembler.addEndurancePart(endurancePart);
        Assert.assertEquals(7, this.assembler.getTotalHitPointModification());
    }

    @Test
    public void addArsenalPartAddsPartWithGivenName() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.assembler.getClass().getDeclaredField("arsenalParts");
        field.setAccessible(true);
        Assert.assertEquals("Attack", ((List<Part>)field.get(this.assembler)).get(0).getModel());
    }

    @Test
    public void addShellPartAddsPartWithGivenName() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.assembler.getClass().getDeclaredField("shellParts");
        field.setAccessible(true);
        Assert.assertEquals("Defence", ((List<Part>)field.get(this.assembler)).get(0).getModel());
    }

    @Test
    public void addEndurancePartAddsPartWithGivenName() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.assembler.getClass().getDeclaredField("enduranceParts");
        field.setAccessible(true);
        Assert.assertEquals("HitPoints", ((List<Part>)field.get(this.assembler)).get(0).getModel());
    }

    @Test(expected = ClassCastException.class)
    public void addShellPartAddsOnlyShellParts(){
        DefenseModifyingPart mock = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addEndurancePart(mock);
    }

    @Test(expected = ClassCastException.class)
    public void addArsenalPartAddsOnlyArsenalParts(){
        HitPointsModifyingPart mock = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addArsenalPart(mock);
    }

    @Test(expected = ClassCastException.class)
    public void addHitPointsPartAddsOnlyHitPointsParts(){
        AttackModifyingPart mock = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addEndurancePart(mock);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("unchecked")
    public void addNullPartThrowsException() throws IllegalAccessException, NoSuchFieldException {
        AttackModifyingPart mock = null;
        this.assembler.addEndurancePart(mock);
        Field field = this.assembler.getClass().getDeclaredField("enduranceParts");
        field.setAccessible(true);
        ((List<Part>)field.get(this.assembler)).get(1).getModel();
    }

    @Test(expected = NullPointerException.class)
    public void assigningAssemblerToNullThrowsException() {
        AttackModifyingPart mock = Mockito.mock(AttackModifyingPart.class);
        this.assembler = null;
        this.assembler.addEndurancePart(mock);
    }
}
