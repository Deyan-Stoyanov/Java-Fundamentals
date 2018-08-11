package hell.factories;

import hell.entities.models.items.RecipeItem;
import hell.interfaces.Recipe;

public class RecipeFactory {
    public static Recipe createRecipe(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String... requiredItems){
        return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
    }
}
