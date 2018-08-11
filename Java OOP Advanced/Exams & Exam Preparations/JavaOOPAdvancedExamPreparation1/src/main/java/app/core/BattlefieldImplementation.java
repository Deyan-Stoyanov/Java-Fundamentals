package app.core;

import app.contracts.*;
import app.util.Config;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;
    private SpecialFactory specialFactory;

    public BattlefieldImplementation(Writer writer, TargetableFactory factory, ActionFactory actionFactory, SpecialFactory specialFactory) {
        this.executedActions = new ArrayList<>();
        this.participants = new LinkedHashMap<>();
        this.writer = writer;
        this.targetableFactory = factory;
        this.actionFactory = actionFactory;
        this.specialFactory = specialFactory;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            List<Targetable> actionParticipants = new ArrayList<>();
            for (String name : participantNames){
                if (this.participants.containsKey(name)){
                    actionParticipants.add(this.participants.get(name));
                } else {
                    writer.writeLine(String.format(Config.HERO_NOT_ON_BATTLEFIELD_MESSAGE, name, actionName));
                    return;
                }
            }
            Action action = this.actionFactory.create(actionName, actionParticipants);
            writer.writeLine(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            writer.writeLine(Config.NON_EXISTANT_ACTION_MESSAGE);
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)){
            writer.writeLine(Config.PARTICIPANT_EXISTS_MESSAGE);
            return;
        }
        Targetable targetable = null;
        try {
            targetable = targetableFactory.create(name, className);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        if(targetable != null){
            this.participants.put(name, targetable);
            writer.writeLine(String.format(Config.PARTICIPANT_ENTERS_BATTLEFIELD_MESSAGE, targetable.getClass().getSimpleName(), targetable.getName()));
        }

    }

    @Override
    public void createSpecial(String name, String specialName) {
        try {
            ((SpecialHero)this.participants.get(name)).assignAbility(this.specialFactory.createSpecial(specialName));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reportParticipants(){
        if (this.participants.size() < 1) {
            writer.writeLine(Config.NO_PARTICIPANTS_ON_BATTLEFIELD_MESSAGE);
            return;
        }

        for (String name : this.participants.keySet()) {
            writer.writeLine(this.participants.get(name).toString());
            writer.writeLine(Config.LINE_SEPARATOR);
        }
    }

    @Override
    public void reportActions(){
        if (this.executedActions.size() < 1) {
            writer.writeLine(Config.NO_ACTIONS_ON_BATTLEFIELD_MESSAGE);
            return;
        }

        for (Action executedAction : executedActions) {
            writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants(){
        Map<String, Targetable> aliveParticipants = new TreeMap<>();
        List<String> names = this.participants.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toCollection(ArrayList::new));
        for (String name : names) {
            if (!this.participants.get(name).isAlive()){
                writer.writeLine(String.format(Config.PARTICIPANT_REMOVED_FROM_BATTLEFIELD_MESSAGE, name));
            }else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}