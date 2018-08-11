package app.models.actions;

import app.contracts.SpecialHero;
import app.contracts.Targetable;
import app.models.participants.Wizard;
import app.models.specials.Heal;
import app.util.Config;

import java.util.List;

public class OneVsOne extends BaseAction {

    public OneVsOne(List<Targetable> participants) {
        super(participants);
    }

    @Override
    public String executeAction(List<Targetable> participants) {
        if (this.getParticipants().size() != 2) {
            return Config.INCORRECT_NUMBER_OF_PARTICIPANTS_ONE_TO_ONE;
        }
        StringBuilder sb = new StringBuilder();
        Targetable firstHero = this.getParticipants().get(0);
        Targetable secondHero = this.getParticipants().get(1);
        if(firstHero instanceof Wizard){
            ((Wizard) firstHero).activateAbility();
        }
        if(secondHero instanceof Wizard){
            ((Wizard) secondHero).activateAbility();
        }
        while (firstHero.isAlive() && secondHero.isAlive()) {
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if(!(firstHero instanceof Wizard)){
                ((SpecialHero)(firstHero)).activateAbility();
            }
            if(secondHero.isAlive()){
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
                if(!(secondHero instanceof Wizard)){
                    ((SpecialHero)(secondHero)).activateAbility();
                }
            }
        }
        if(!(((SpecialHero)firstHero).getSpecial() instanceof Heal)){
            ((SpecialHero) firstHero).deactivateAbility();
        }
        if(!(((SpecialHero)secondHero).getSpecial() instanceof Heal)){
            ((SpecialHero) secondHero).deactivateAbility();
        }
        sb.append(String.format(Config.PARTICIPANT_WINS_ONE_TO_ONE,
                firstHero.isAlive() ? firstHero.getName() : secondHero.getName(),
                System.lineSeparator(),
                firstHero.isAlive() ? firstHero.toString() : secondHero.toString()));
        return sb.toString();
    }
}
