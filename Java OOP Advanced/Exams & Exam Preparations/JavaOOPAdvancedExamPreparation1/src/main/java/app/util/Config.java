package app.util;

public final class Config {

    public static final int HERO_HEALTH_MULTIPLIER = 10;
    public static final int LEVEL_UP_MULTIPLIER = 2;

    public static final int WIZARD_BASE_STRENGTH = 3;
    public static final int WIZARD_BASE_DEXTERITY= 3;
    public static final int WIZARD_BASE_INTELLIGENCE = 4;

    public static final int WARRIOR_BASE_STRENGTH = 5;
    public static final int WARRIOR_BASE_DEXTERITY= 4;
    public static final int WARRIOR_BASE_INTELLIGENCE = 1;

    public static final int NECROMANCER_BASE_STRENGTH = 4;
    public static final int NECROMANCER_BASE_DEXTERITY = 3;
    public static final int NECROMANCER_BASE_INTELLIGENCE = 3;

    public static final double HERO_START_GOLD = 200.0;
    
    public static final double BOSS_GOLD = 100;
    public static final double BOSS_GOLD_MULTIPLIER = 0.1;
    public static final double BOSS_HEALTH = 500;
    public static final double BOSS_DAMAGE = 5;
    public static final double BOSS_INDIVIDUAL_REWARD = 50;

    public static final String END_COMMAND = "Peace";
    public static final String CREATE_PARTICIPANT_COMMAND = "CreateParticipant";
    public static final String CREATE_ACTION_COMMAND = "CreateAction";
    public static final String CREATE_SPECIAL_COMMAND = "CreateSpecial";
    public static final String STAT_PARTICIPANT_COMMAND = "StatParticipants";
    public static final String STAT_ACTION_COMMAND = "StatActions";

    public static final String INVALID_COMMAND_MESSAGE = "Invalid command";
    public static final String HERO_NOT_ON_BATTLEFIELD_MESSAGE = "%s is not on the battlefield. %s failed.";
    public static final String NON_EXISTANT_ACTION_MESSAGE = "Action does not exist.";
    public static final String PARTICIPANT_EXISTS_MESSAGE = "Participant with that name already exists.";
    public static final String PARTICIPANT_ENTERS_BATTLEFIELD_MESSAGE = "%s %s entered the battlefield.";
    public static final String NO_PARTICIPANTS_ON_BATTLEFIELD_MESSAGE = "There are no participants on the battlefield.";
    public static final String NO_ACTIONS_ON_BATTLEFIELD_MESSAGE = "There are no actions on the battlefield.";
    public static final String PARTICIPANT_REMOVED_FROM_BATTLEFIELD_MESSAGE = "%s has been removed from the battlefield.";
    public static final String PARTICIPANT_WINS_ONE_TO_ONE = "%s is victorious!%s%s";
    public static final String INCORRECT_NUMBER_OF_PARTICIPANTS_ONE_TO_ONE = "There should be exactly 2 participants for OneVsOne!";
    public static final String INCORRECT_NUMBER_OF_PARTICIPANTS_BOSS_FIGHT = "There should be at least 1 participant for boss fight!";
    public static final String INVALID_BOSS_MESSAGE = "Invalid boss.";
    public static final String BOSS_WINS_MESSAGE = "Boss has slain them all!";
    public static final String BOSS_LOSES_MESSAGE = " has been slain by: ";
    public static final String ATTACKER_DEAD_MESSAGE = " is dead! Cannot attack.";
    public static final String TARGET_DEAD_MESSAGE = " is dead! Cannot be attacked.";
    public static final String TARGET_ATTACKED_MESSAGE = " attacked!";
    public static final String TARGET_SLAIN_MESSAGE = " %s has been slain by %s.";

    public static final String LINE_SEPARATOR = "* * * * * * * * * * * * * * * * * * * *";

    public static final String ACTION_PACKAGE_PATH = "app.models.actions.";
    public static final String SPECIALS_PACKAGE_PATH = "app.models.specials.";
    public static final String TARGETABLE_PACKAGE_PATH = "app.models.participants.";
}