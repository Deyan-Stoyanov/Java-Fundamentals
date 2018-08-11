package hell.entities.miscellaneous;

import hell.factories.ItemFactory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;
import java.util.stream.Collectors;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<>();
        this.recipeItems = new LinkedHashMap<>();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.entrySet().stream().mapToInt((x) -> x.getValue().getStrengthBonus()).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.entrySet().stream().mapToInt((x) -> x.getValue().getAgilityBonus()).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.entrySet().stream().mapToInt((x) -> x.getValue().getIntelligenceBonus()).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.entrySet().stream().mapToInt((x) -> x.getValue().getHitPointsBonus()).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.entrySet().stream().mapToInt((x) -> x.getValue().getDamageBonus()).sum();
    }

    @Override
    public void addCommonItem(Item item) {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() {
        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = recipe.getRequiredItems().stream().filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));

            for (Item item : this.commonItems.values()) {
                requiredItems.remove(item.getName());
            }

            if (requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
                break;
            }
        }
    }

    private void combineRecipe(Recipe recipe) {

        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);
        }

        //TODO: Initialize the newItem variable, with an object of the CommonItem class.
        //TODO: Initialize the newItem variable, with the stat bonuses of the "recipe" parameter.
        Item newItem = ItemFactory.createItem(recipe.getName(), recipe.getStrengthBonus(), recipe.getAgilityBonus(), recipe.getIntelligenceBonus(), recipe.getHitPointsBonus(), recipe.getDamageBonus());
        this.commonItems.put(newItem.getName(), newItem);
    }


    @Override
    public String toString() {
        if(this.commonItems.isEmpty()){
            return " None";
        }
        StringBuilder sb = new StringBuilder();
        for (Item item : commonItems.values()) {
            sb.append(String.format("%n###Item: %s%n" +
                    "###+%d Strength%n" +
                    "###+%d Agility%n" +
                    "###+%d Intelligence%n" +
                    "###+%d HitPoints%n" +
                    "###+%d Damage", item.getName(), item.getStrengthBonus(), item.getAgilityBonus(), item.getIntelligenceBonus(), item.getHitPointsBonus(), item.getDamageBonus()));
        }
        return sb.toString();
    }
}