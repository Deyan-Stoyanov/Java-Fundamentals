package hell.factories;

import hell.entities.models.items.CommonItem;
import hell.interfaces.Item;

public class ItemFactory {

    public static Item createItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus){
        return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }
}
