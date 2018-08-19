package callofduty.core;

import callofduty.domain.missions.EscortMission;
import callofduty.domain.missions.HuntMission;
import callofduty.domain.missions.SurveillanceMission;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MissionControlTests {
    private MissionControl missionControl;

    @Before
    public void init(){
        this.missionControl = new MissionControlImpl();
    }

    @Test
    public void IdContainsOnly8Symbols(){
        Mission mission = this.missionControl.generateMission("asdasdasdasdasd", 10D, 10D);
        Assert.assertEquals(8, mission.getId().length());
    }

    @Test
    public void ratingCannotBeOver100() throws NoSuchFieldException, IllegalAccessException {
        Mission mission = this.missionControl.generateMission("asd", 1000D, 10D);
        Field field = mission.getClass().getSuperclass().getDeclaredField("rating");
        field.setAccessible(true);
        Assert.assertEquals(100, (Double) field.get(mission), 0.005);
    }

    @Test
    public void ratingCannotBeNegative() throws NoSuchFieldException, IllegalAccessException {
        Mission mission = this.missionControl.generateMission("asd", -20D, 10D);
        Field field = mission.getClass().getSuperclass().getDeclaredField("rating");
        field.setAccessible(true);
        Assert.assertEquals(0, (Double) field.get(mission), 0.005);
    }

    @Test
    public void bountyCannotBeOver100000() throws NoSuchFieldException, IllegalAccessException {
        Mission mission = this.missionControl.generateMission("asd", 10D, 2_000_000_000D);
        Field field = mission.getClass().getSuperclass().getDeclaredField("bounty");
        field.setAccessible(true);
        Assert.assertEquals(100_000, (Double) field.get(mission), 0.005);
    }

    @Test
    public void bountyCannotBeNegative() throws NoSuchFieldException, IllegalAccessException {
        Mission mission = this.missionControl.generateMission("asd", 20D, -2.5D);
        Field field = mission.getClass().getSuperclass().getDeclaredField("bounty");
        field.setAccessible(true);
        Assert.assertEquals(0, (Double) field.get(mission), 0.005);
    }

    @Test
    public void generatedMissionsAreInCertainRow(){
        Mission mission1 = this.missionControl.generateMission("asd", 10D, 10D);
        Mission mission2 = this.missionControl.generateMission("asd", 10D, 10D);
        Mission mission3 = this.missionControl.generateMission("asd", 10D, 10D);
        Assert.assertEquals("EscortMission", mission1.getClass().getSimpleName());
        Assert.assertEquals("HuntMission", mission2.getClass().getSimpleName());
        Assert.assertEquals("SurveillanceMission", mission3.getClass().getSimpleName());
    }


    @Test
    public void mapContainsAllMissionNames() throws NoSuchFieldException, IllegalAccessException {
        Mission mission1 = this.missionControl.generateMission("asd", 10D, 10D);
        Mission mission2 = this.missionControl.generateMission("asd", 10D, 10D);
        Mission mission3 = this.missionControl.generateMission("asd", 10D, 10D);
        Field field = this.missionControl.getClass().getDeclaredField("missionClasses");
        field.setAccessible(true);
        Map<String, Class> classes = (Map<String, Class>) field.get(this.missionControl);
        Assert.assertEquals(classes.get(mission1.getClass().getSimpleName()), mission1.getClass());
        Assert.assertEquals(classes.get(mission2.getClass().getSimpleName()), mission2.getClass());
        Assert.assertEquals(classes.get(mission3.getClass().getSimpleName()), mission3.getClass());
    }

    @Test
    public void mapClassNamesAreEqualToMapKeys() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.missionControl.getClass().getDeclaredField("missionClasses");
        field.setAccessible(true);
        Map<String, Class> classes = (Map<String, Class>) field.get(this.missionControl);
        for (Map.Entry<String, Class> entry : classes.entrySet()) {
            Assert.assertEquals(entry.getKey(), entry.getValue().getSimpleName());
        }
    }

    @Test
    public void IdIsSubstringed(){
        Mission mission = this.missionControl.generateMission("asdasdasdasdasd", 10D, 10D);
        Assert.assertEquals("asdasdas", mission.getId());
    }

    @Test
    public void testOfIterator(){
        Mission mission = this.missionControl.generateMission("asd", 10D, 10D);
        this.missionControl.generateMission("asd", 10D, 10D);
        this.missionControl.generateMission("asd", 10D, 10D);
        Mission mission3 = this.missionControl.generateMission("asd", 10D, 10D);
        Assert.assertEquals(mission.getClass().getSimpleName(), mission3.getClass().getSimpleName());
    }

    @Test
    public void testOfMissionClass(){
        Mission mission = this.missionControl.generateMission("asd", 10D, 10D);
        Assert.assertEquals(mission.getClass(), EscortMission.class);
    }

    @Test
    public void testOfMissionClass2(){
        this.missionControl.generateMission("asd", 10D, 10D);
        Mission mission = this.missionControl.generateMission("asd", 10D, 10D);
        Assert.assertEquals(mission.getClass(), HuntMission.class);
    }

    @Test
    public void testOfMissionClass3(){
        this.missionControl.generateMission("asd", 10D, 10D);
        this.missionControl.generateMission("asd", 10D, 10D);
        Mission mission = this.missionControl.generateMission("asd", 10D, 10D);
        Assert.assertEquals(mission.getClass(), SurveillanceMission.class);
    }

    @Test
    public void test1(){
        Mission mission = this.missionControl.generateMission("asd", 10D, 10D);
        Mission mock = Mockito.mock(EscortMission.class);
        Mockito.when(mock.getBounty()).thenReturn(12.5);
        Assert.assertEquals(mission.getBounty(), mock.getBounty());
    }

    @Test(expected = NullPointerException.class)
    public void test2(){
       this.missionControl.generateMission(null, 10D, 10D);
    }

    @Test(expected = NullPointerException.class)
    public void test3(){
        this.missionControl.generateMission("", null, 10D);
    }

    @Test
    public void test4(){
        Mission mission = this.missionControl.generateMission("", 100D, 100000D);
        Assert.assertEquals(125000, mission.getBounty(), 0.005);
    }

    @Test
    public void test5(){
        Mission mission = this.missionControl.generateMission("", 0D, 100000D);
        Assert.assertEquals(0, mission.getRating(), 0.005);
    }

    @Test
    public void test6(){
        List<Class> a = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            a.add(this.missionControl.generateMission("", 0D, 100000D).getClass());
        }
        Assert.assertEquals(33, a.stream().filter(x -> x == EscortMission.class).count());
    }

    @Test
    public void test7(){
        Mission mission = this.missionControl.generateMission("asd", 20D, 10D);
        Assert.assertTrue(mission instanceof EscortMission);
    }

    @Test
    public void test8() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Mission mission = this.missionControl.generateMission("asd", 20D, 10D);
        Method method = this.missionControl.getClass().getDeclaredMethod("currentMission");
        method.setAccessible(true);
        Class c = (Class) method.invoke(this.missionControl);
        Assert.assertEquals(c, HuntMission.class);
    }

    @Test(expected = ClassCastException.class)
    public void test87(){
        HuntMission mission = (HuntMission) this.missionControl.generateMission("asd", 20D, 10D);
    }


    @Test
    public void test85(){
        Mission mission =  this.missionControl.generateMission("asd", 20D, 10D);
        Assert.assertEquals("asd", mission.getId());
    }
}
