package hell.entities.models.heroes;

import hell.util.Config;

public class Barbarian extends BaseHero {
    public Barbarian(String name) {
        super(name, Config.BARBARIAN_STRENGTH, Config.BARBARIAN_AGILITY, Config.BARBARIAN_INTELLIGENCE, Config.BARBARIAN_HITPOINTS, Config.BARBARIAN_DAMAGE);
    }
}
