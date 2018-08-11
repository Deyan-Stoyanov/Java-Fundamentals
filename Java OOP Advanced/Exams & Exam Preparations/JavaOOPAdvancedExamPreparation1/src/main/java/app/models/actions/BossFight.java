package app.models.actions;

import app.contracts.SpecialHero;
import app.contracts.Targetable;
import app.models.participants.Wizard;
import app.models.specials.Heal;
import app.util.Config;
import app.models.participants.Boss;

import java.util.Comparator;
import java.util.List;

public class BossFight extends BaseAction {

    public BossFight(List<Targetable> participants) {
        super(participants);
    }

    @Override
    public String executeAction(List<Targetable> participants) {
        if (this.getParticipants().isEmpty()) {
            return Config.INCORRECT_NUMBER_OF_PARTICIPANTS_BOSS_FIGHT;
        }
        if (!(this.getParticipants().get(0) instanceof Boss)) {
            return Config.INVALID_BOSS_MESSAGE;
        }
        Boss boss = (Boss) this.getParticipants().get(0);
        int i = 0;
        while (boss.isAlive() && this.getParticipants().stream().filter(x -> !(x instanceof Boss)).anyMatch(Targetable::isAlive)) {
            this.removeDeadParticipants();
            i++;
            if (i >= this.getParticipants().size()) {
                i = 1;
            }
            Targetable hero = this.getParticipants().get(i);
            if((hero instanceof Wizard)){
                ((SpecialHero)(hero)).activateAbility();
            }
            boss.attack(hero);
            if(!(hero instanceof Wizard)){
                ((SpecialHero)(hero)).activateAbility();
            }
            hero.attack(boss);
            if(!(((SpecialHero)hero).getSpecial() instanceof Heal)){
                ((SpecialHero) hero).deactivateAbility();
            }
        }
        if (this.getParticipants().stream().filter(x -> !(x instanceof Boss)).noneMatch(Targetable::isAlive)) {
            return Config.BOSS_WINS_MESSAGE;
        }
        String winnerName = this.getParticipants().get(i).getName();
        this.getParticipants().stream().filter(x -> !x.getName().equalsIgnoreCase(winnerName)).forEach(Targetable::levelUp);
        this.getParticipants().forEach(x -> x.receiveReward(Config.BOSS_INDIVIDUAL_REWARD));
        StringBuilder sb = new StringBuilder();
        sb.append(boss.getClass().getSimpleName()).append(Config.BOSS_LOSES_MESSAGE);
        participants.stream().filter(Targetable::isAlive).sorted(Comparator.comparing(Targetable::getName)).forEach(x -> sb.append(System.lineSeparator()).append(x.toString()));
        return sb.toString();
    }
}
