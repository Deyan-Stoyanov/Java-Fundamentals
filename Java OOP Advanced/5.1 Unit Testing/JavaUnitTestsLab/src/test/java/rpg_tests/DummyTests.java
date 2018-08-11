package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    public static final int INITIAL_STATS = 10;
    public static final int FINAL_DUMMY_STATS = 0;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void createUnits() {
        this.axe = new Axe(INITIAL_STATS, INITIAL_STATS);
        this.dummy = new Dummy(INITIAL_STATS, INITIAL_STATS);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {

        this.dummy.takeAttack(axe.getAttackPoints());
        Assert.assertEquals("Dummy must lose health if attacked!", FINAL_DUMMY_STATS, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void dummyThrowsExceptionIfAttackedWhileDead() {
        this.dummy.takeAttack(this.axe.getAttackPoints());
        this.dummy.takeAttack(this.axe.getAttackPoints());
    }

    @Test
    public void deadDummyCanGiveExperience() {
        this.dummy.takeAttack(this.axe.getAttackPoints());
        this.dummy.giveExperience();
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveExperience() {
        this.dummy.giveExperience();
    }
}
