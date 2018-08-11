package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public class HeroInventoryTests {
    private Inventory inventory;
    @Before
    public void init(){
        this.inventory = new HeroInventory();
        Item commonItem = Mockito.mock(Item.class);
        Mockito.when(commonItem.getName()).thenReturn("Knife");
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(1);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(1);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(1);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(commonItem.getStrengthBonus()).thenReturn(1);

        Recipe recipeItem = Mockito.mock(Recipe.class);
        Mockito.when(recipeItem.getName()).thenReturn("Spear");
        Mockito.when(recipeItem.getAgilityBonus()).thenReturn(1);
        Mockito.when(recipeItem.getDamageBonus()).thenReturn(1);
        Mockito.when(recipeItem.getHitPointsBonus()).thenReturn(1);
        Mockito.when(recipeItem.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(recipeItem.getStrengthBonus()).thenReturn(1);
        Mockito.when(recipeItem.getRequiredItems()).thenReturn(new ArrayList<>(){{
            add("Knife");
        }});
        this.inventory.addCommonItem(commonItem);
        this.inventory.addRecipeItem(recipeItem);
    }

    @Test
    public void addCommonItemWorks() throws NoSuchFieldException, IllegalAccessException {
        Item commonItem = Mockito.mock(Item.class);
        Mockito.when(commonItem.getName()).thenReturn("Spoon");
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(1);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(1);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(1);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(commonItem.getStrengthBonus()).thenReturn(1);
        this.inventory.addCommonItem(commonItem);
        Field commonItems = this.inventory.getClass().getDeclaredField("commonItems");
        commonItems.setAccessible(true);
        Assert.assertEquals(2, ((Map)(commonItems.get(this.inventory))).size());
    }

    @Test
    public void addRecipeWorks() throws NoSuchFieldException, IllegalAccessException {
        Recipe recipeItem = Mockito.mock(Recipe.class);
        Mockito.when(recipeItem.getName()).thenReturn("Stick");
        Mockito.when(recipeItem.getAgilityBonus()).thenReturn(1);
        Mockito.when(recipeItem.getDamageBonus()).thenReturn(1);
        Mockito.when(recipeItem.getHitPointsBonus()).thenReturn(1);
        Mockito.when(recipeItem.getIntelligenceBonus()).thenReturn(1);
        Mockito.when(recipeItem.getStrengthBonus()).thenReturn(1);
        Mockito.when(recipeItem.getRequiredItems()).thenReturn(new ArrayList<>(){{
            add("AsdAsd");
        }});
        this.inventory.addRecipeItem(recipeItem);
        Field recipeItems = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItems.setAccessible(true);
        Assert.assertEquals(2, ((Map)(recipeItems.get(this.inventory))).size());
    }

    @Test
    public void getTotalStrengthBonusWorks(){
        Assert.assertEquals(1, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonusWorks(){
        Assert.assertEquals(1, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonusWorks(){
        Assert.assertEquals(1, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalDamageBonusWorks(){
        Assert.assertEquals(1, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void getTotalHitPointsBonusWorks(){
        Assert.assertEquals(1, this.inventory.getTotalHitPointsBonus());
    }
}
