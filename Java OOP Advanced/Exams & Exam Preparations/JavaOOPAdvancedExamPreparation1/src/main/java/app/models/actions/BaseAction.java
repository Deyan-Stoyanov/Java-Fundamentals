package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAction implements Action {
    private List<Targetable> participants;

    protected BaseAction(List<Targetable> participants) {
        this.participants = participants;
    }

    public List<Targetable> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    protected void removeDeadParticipants(){
        this.participants = this.participants.stream().filter(Targetable::isAlive).collect(Collectors.toCollection(ArrayList::new));
    }
}
