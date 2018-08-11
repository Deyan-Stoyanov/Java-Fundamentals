package models;

import abstractions.Observer;
import abstractions.Subject;
import abstractions.Target;
import enums.LogType;
import abstractions.Handler;

import java.util.ArrayList;
import java.util.List;

public class Dragon implements Target, Subject {

    private static final String THIS_DIED_EVENT = "%s dies";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private Handler handler;
    private List<Observer> observers;

    public Dragon(String id, int hp, int reward, Handler handler) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.handler = handler;
        this.observers = new ArrayList<>();
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
        }

        if (this.isDead() && !eventTriggered) {
            handler.handle(LogType.EVENT, String.format(THIS_DIED_EVENT, this));
            this.eventTriggered = true;
        }

        if(eventTriggered){
            notifyObserver();
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            handler.handle(LogType.EVENT, observer.getId() + " defeated " + this.id);
            observer.update(this.reward);
        }
    }
}
