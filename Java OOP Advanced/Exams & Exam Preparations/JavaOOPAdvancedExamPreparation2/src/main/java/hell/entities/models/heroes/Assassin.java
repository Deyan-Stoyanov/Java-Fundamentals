package hell.entities.models.heroes;

import hell.util.Config;

public class Assassin extends BaseHero{
    public Assassin(String name) {
        super(name, Config.ASSASSIN_STRENGTH, Config.ASSASSIN_AGILITY, Config.ASSASSIN_INTELLIGENCE, Config.ASSASSIN_HITPOINTS, Config.ASSASSIN_DAMAGE);
    }
}
