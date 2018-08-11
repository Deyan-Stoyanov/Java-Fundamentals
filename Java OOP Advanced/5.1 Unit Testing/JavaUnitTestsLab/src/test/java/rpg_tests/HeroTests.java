package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {
    public static final int INITIAL_STATS = 10;
    public static final String HERO_NAME = "Pesho";

    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Target fakeTarget = Mockito.mock(Target.class);
        Weapon fakeWeapon = Mockito.mock(Weapon.class);
        Mockito.when(fakeTarget.isDead()).thenReturn(true);
        Mockito.when(fakeTarget.giveExperience()).thenReturn(INITIAL_STATS);
        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        int targetWeaponsCount = fakeTarget.getPossibleLoot().size();
        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience.", INITIAL_STATS, hero.getExperience());
        Assert.assertEquals("Hero should get target's loot when target dies.", targetWeaponsCount, hero.getInventory().size());
    }
}
