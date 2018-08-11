package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

public class ModuleContainerTests {
    private ModuleContainer moduleContainer;

    @Before
    public void init() {
        moduleContainer = new ModuleContainer(5);
    }

    private void initializeEnergyModules() {
        for (int i = 0; i < 10; i++) {
            EnergyModule mockedModule = Mockito.mock(EnergyModule.class);
            Mockito.when(mockedModule.getEnergyOutput()).thenReturn(10);
            Mockito.when(mockedModule.getId()).thenReturn(i);
            moduleContainer.addEnergyModule(mockedModule);
        }
    }

    private void initializeAbsorbantModules() {
        for (int i = 0; i < 10; i++) {
            AbsorbingModule mockedModule = Mockito.mock(AbsorbingModule.class);
            Mockito.when(mockedModule.getHeatAbsorbing()).thenReturn(10);
            Mockito.when(mockedModule.getId()).thenReturn(i);
            moduleContainer.addAbsorbingModule(mockedModule);
        }
    }

    @Test
    public void getTotalEnergyOutputReturnsAllEnergyOutputs() {
        initializeEnergyModules();
        Assert.assertEquals(50, this.moduleContainer.getTotalEnergyOutput());
    }

    @Test
    public void addEnergyModuleAddsEnergyModule() throws IllegalAccessException, NoSuchFieldException {
        initializeEnergyModules();
        Field field = ModuleContainer.class.getDeclaredField("energyModules");
        field.setAccessible(true);
        int total = (int) ((Map) (field.get(this.moduleContainer))).values().stream().filter(x -> x instanceof EnergyModule).count();
        Assert.assertEquals(5, total);
    }

    @Test
    public void getTotalHeatAbsorbingReturnsAllHeatAbsorbings() {
        initializeAbsorbantModules();
        Assert.assertEquals(50, this.moduleContainer.getTotalHeatAbsorbing());
    }

    @Test
    public void addAbsorbingModuleAddsAbsorbingModule() throws IllegalAccessException, NoSuchFieldException {
        initializeAbsorbantModules();
        Field field = ModuleContainer.class.getDeclaredField("absorbingModules");
        field.setAccessible(true);
        int total = (int) ((Map) (field.get(this.moduleContainer))).values().stream().filter(x -> x instanceof AbsorbingModule).count();
        Assert.assertEquals(5, total);
    }

    @Test
    public void addedModulesDoNotExceedTotalCapacity() throws NoSuchFieldException, IllegalAccessException {
        Field capacityField = moduleContainer.getClass().getDeclaredField("moduleCapacity");
        capacityField.setAccessible(true);
        int capacity = (int) capacityField.get(this.moduleContainer);
        for (int i = 0; i < 10; i++) {
            AbsorbingModule mockedModule = Mockito.mock(AbsorbingModule.class);
            Mockito.when(mockedModule.getHeatAbsorbing()).thenReturn(10);
            Mockito.when(mockedModule.getId()).thenReturn(i);
            moduleContainer.addAbsorbingModule(mockedModule);
            Field field = moduleContainer.getClass().getDeclaredField("modulesByInput");
            field.setAccessible(true);
            int currentItems = (int) ((LinkedList) (field.get(this.moduleContainer))).stream().filter(x -> x instanceof AbsorbingModule).count();
            Assert.assertTrue(currentItems <= capacity);
        }
    }

    @Test
    public void notAddingModulesReturnsZero(){
        Assert.assertEquals(0, this.moduleContainer.getTotalEnergyOutput());
        Assert.assertEquals(0, this.moduleContainer.getTotalHeatAbsorbing());
    }

    @Test
    public void removeOldestModule() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method method = this.moduleContainer.getClass().getDeclaredMethod("removeOldestModule");
        method.setAccessible(true);
        this.initializeAbsorbantModules();
        method.invoke(this.moduleContainer);
        Field field = moduleContainer.getClass().getDeclaredField("absorbingModules");
        field.setAccessible(true);
        int currentItems = (int) ((Map) (field.get(this.moduleContainer))).values().stream().filter(x -> x instanceof AbsorbingModule).count();
        Assert.assertEquals(4, currentItems);
    }

    @Test
    public void removeTheOldestAbsorbingModules(){
        for (int i = 0; i < 5; i++) {
            AbsorbingModule mockedModule = Mockito.mock(AbsorbingModule.class);
            Mockito.when(mockedModule.getHeatAbsorbing()).thenReturn(5);
            Mockito.when(mockedModule.getId()).thenReturn(i);
            moduleContainer.addAbsorbingModule(mockedModule);
        }
        for (int i = 0; i < 5; i++) {
            AbsorbingModule mockedModule = Mockito.mock(AbsorbingModule.class);
            Mockito.when(mockedModule.getHeatAbsorbing()).thenReturn(10);
            Mockito.when(mockedModule.getId()).thenReturn(i);
            moduleContainer.addAbsorbingModule(mockedModule);
        }
        Assert.assertEquals(50, this.moduleContainer.getTotalHeatAbsorbing());
    }

    @Test
    public void removeTheOldestEnergyModules(){
        for (int i = 0; i < 5; i++) {
            EnergyModule mockedModule = Mockito.mock(EnergyModule.class);
            Mockito.when(mockedModule.getEnergyOutput()).thenReturn(5);
            Mockito.when(mockedModule.getId()).thenReturn(i);
            moduleContainer.addEnergyModule(mockedModule);
        }
        for (int i = 0; i < 5; i++) {
            EnergyModule mockedModule = Mockito.mock(EnergyModule.class);
            Mockito.when(mockedModule.getEnergyOutput()).thenReturn(10);
            Mockito.when(mockedModule.getId()).thenReturn(i);
            moduleContainer.addEnergyModule(mockedModule);
        }
        Assert.assertEquals(50, this.moduleContainer.getTotalEnergyOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAdsorbingNullThrowsException(){
        this.moduleContainer.addAbsorbingModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyNullThrowsException(){
        this.moduleContainer.addEnergyModule(null);
    }

    @Test
    public void addingUnitsWithSameIdDoesntWork() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < 5; i++) {
            AbsorbingModule mockedModule = Mockito.mock(AbsorbingModule.class);
            Mockito.when(mockedModule.getHeatAbsorbing()).thenReturn(10);
            Mockito.when(mockedModule.getId()).thenReturn(1);
            moduleContainer.addAbsorbingModule(mockedModule);
        }
        Field field = moduleContainer.getClass().getDeclaredField("absorbingModules");
        field.setAccessible(true);
        int currentItems = (int) ((Map) (field.get(this.moduleContainer))).values().stream().filter(x -> x instanceof AbsorbingModule).count();
        Assert.assertEquals(1, currentItems);
        Field field1 = moduleContainer.getClass().getDeclaredField("modulesByInput");
        field1.setAccessible(true);
        int currentItems1 = (int) ((LinkedList) (field1.get(this.moduleContainer))).stream().filter(x -> x instanceof AbsorbingModule).count();
        Assert.assertEquals(5, currentItems1);
    }
}