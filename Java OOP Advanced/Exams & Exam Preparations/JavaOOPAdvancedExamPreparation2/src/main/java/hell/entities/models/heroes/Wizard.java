package hell.entities.models.heroes;

import hell.util.Config;

public class Wizard extends BaseHero{
    public Wizard(String name) {
        super(name, Config.WIZARD_STRENGTH, Config.WIZARD_AGILITY, Config.WIZARD_INTELLIGENCE, Config.WIZARD_HITPOINTS, Config.WIZARD_DAMAGE);
    }
}
