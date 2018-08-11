package hell.entities.models.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.models.items.CommonItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseHero implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private HeroInventory items;

    protected BaseHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.items = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.items.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.items.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.items.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.items.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.items.getTotalDamageBonus();
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try {
            Field recipeItems = this.items.getClass().getDeclaredField("commonItems");
            Field commonItems = this.items.getClass().getDeclaredField("recipeItems");
            recipeItems.setAccessible(true);
            commonItems.setAccessible(true);
            ((Map)(commonItems.get(this.items))).values().forEach(x -> items.add((Item) x));
            ((Map)(recipeItems.get(this.items))).values().forEach(x -> items.add((Item) x));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(items);
    }

    @Override
    public void addItem(Item item) {
        this.items.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.items.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        return String.format("Hero: %s, Class: %s%n" +
               "HitPoints: %d, Damage: %d%n" +
               "Strength: %d%n" +
               "Agility: %d%n" +
               "Intelligence: %d%n" +
               "Items:%s",
               this.getName(), this.getClass().getSimpleName(), this.getHitPoints(), this.getDamage(), this.getStrength(), this.getAgility(), this.getIntelligence(), this.items.toString());
    }

    public String resultString(){
        return String.format("%s: %s%n" +
                        "###HitPoints: %d%n" +
                        "###Damage: %d%n" +
                        "###Strength: %d%n" +
                        "###Agility: %d%n" +
                        "###Intelligence: %d%n" +
                        "###Items: %s%n",
                this.getClass().getSimpleName(), this.getName(), this.getHitPoints(), this.getDamage(), this.getStrength(), this.getAgility(), this.getIntelligence(), this.getItems().stream().noneMatch(x -> x instanceof CommonItem) ? "None" : String.join(", ", this.getItems().stream().filter(x -> x instanceof CommonItem).map(Item::getName).collect(Collectors.toList())));
    }
}
