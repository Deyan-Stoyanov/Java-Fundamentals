package hell.interfaces;

/**
 *  This is the interface for the BaseItem entity
 *  @method String getName() - a getter for the name property of the BaseItem
 *  @method long getStrengthBonus() - a getter for the strengthBonus property of the BaseItem
 *  @method long getAgilityBonus() - a getter for the agilityBonus property of the BaseItem
 *  @method long getIntelligenceBonus() - a getter for the intelligenceBonus property of the BaseItem
 *  @method long getHitPointsBonus() - a getter for the hitPointsBonus property of the BaseItem
 *  @method long getDamageBonus() - a getter for the damageBonus property of the BaseItem
 */
public interface Item {
    String getName();

    int getStrengthBonus();

    int getAgilityBonus();

    int getIntelligenceBonus();

    int getHitPointsBonus();

    int getDamageBonus();
}