package bg.softuni.manager;

import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.Manager;
import bg.softuni.models.collection.LStack;
import bg.softuni.models.enums.FragmentType;
import bg.softuni.util.Const;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

public class ManagerTests {

    private Manager manager;

    @Before
    public void init(){
        this.manager = new ManagerImpl();
    }

    @Test
    public void selectCommand() throws IllegalAccessException, NoSuchFieldException {
        Core mockCore1 = Mockito.mock(Core.class);
        Mockito.when(mockCore1.getName()).thenReturn("A");
        Core mockCore2 = Mockito.mock(Core.class);
        Mockito.when(mockCore2.getName()).thenReturn("B");
        Field field = this.manager.getClass().getDeclaredField("cores");
        field.setAccessible(true);
        ((List<Core>)field.get(this.manager)).add(mockCore1);
        ((List<Core>)field.get(this.manager)).add(mockCore2);
        this.manager.selectCore(new String[]{"A"});
        Field fieldCore = this.manager.getClass().getDeclaredField("selectedCore");
        fieldCore.setAccessible(true);
        Assert.assertEquals("A", ((Core)fieldCore.get(this.manager)).getName());
    }

    @Test
    public void attachFragment() throws IllegalAccessException, NoSuchFieldException {
        Core mockCore1 = Mockito.mock(Core.class);
        Mockito.when(mockCore1.getName()).thenReturn("A");
        Mockito.when(mockCore1.getFragments()).thenReturn(new LStack());
        Core mockCore2 = Mockito.mock(Core.class);
        Mockito.when(mockCore2.getName()).thenReturn("B");
        Field field = this.manager.getClass().getDeclaredField("cores");
        field.setAccessible(true);
        ((List<Core>)field.get(this.manager)).add(mockCore1);
        ((List<Core>)field.get(this.manager)).add(mockCore2);
        this.manager.selectCore(new String[]{"A"});
        this.manager.attachFragment(new String[]{"Cooling", "Pesho", "20"});
        Assert.assertEquals("Pesho", mockCore1.getFragments().peek().getName());
        Assert.assertEquals(java.util.Optional.of(60).get(), mockCore1.getFragments().peek().getPressureAffection());
        Assert.assertEquals(FragmentType.Cooling, mockCore1.getFragments().peek().getType() );
    }

    @Test
    public void detachFragmentThrowsException() throws IllegalAccessException, NoSuchFieldException {
        Core mockCore1 = Mockito.mock(Core.class);
        Mockito.when(mockCore1.getName()).thenReturn("A");
        Mockito.when(mockCore1.getFragments()).thenReturn(new LStack());
        Core mockCore2 = Mockito.mock(Core.class);
        Mockito.when(mockCore2.getName()).thenReturn("B");
        Field field = this.manager.getClass().getDeclaredField("cores");
        field.setAccessible(true);
        ((List<Core>)field.get(this.manager)).add(mockCore1);
        ((List<Core>)field.get(this.manager)).add(mockCore2);
        this.manager.selectCore(new String[]{"A"});
        Assert.assertEquals(Const.DETACH_FRAGMENT_ERROR_MESSAGE, this.manager.detachFragment(new String[0]));
    }

    @Test
    public void detachFragment() throws IllegalAccessException, NoSuchFieldException {
        Core mockCore1 = Mockito.mock(Core.class);
        Mockito.when(mockCore1.getName()).thenReturn("A");
        Mockito.when(mockCore1.getFragments()).thenReturn(new LStack());
        Core mockCore2 = Mockito.mock(Core.class);
        Mockito.when(mockCore2.getName()).thenReturn("B");
        Field field = this.manager.getClass().getDeclaredField("cores");
        field.setAccessible(true);
        ((List<Core>)field.get(this.manager)).add(mockCore1);
        ((List<Core>)field.get(this.manager)).add(mockCore2);
        this.manager.selectCore(new String[]{"A"});
        this.manager.attachFragment(new String[]{"Cooling", "Pesho", "20"});
        this.manager.detachFragment(new String[0]);
        Assert.assertTrue(mockCore1.getFragments().isEmpty());
    }
}
