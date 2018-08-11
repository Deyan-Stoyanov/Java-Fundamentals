package problem1_event_implementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> listeners;

    public Dispatcher(String name) {
        this.name = name;
        this.listeners = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<NameChangeListener> getListeners() {
        return this.listeners;
    }

    public void addNameChangeListener(NameChangeListener listener){
        this.listeners.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener){
        this.listeners.remove(listener);
    }

    public void fireNameChangeEvent(NameChange event){
        this.listeners.forEach(x -> x.handleNameChange(event));
    }
}
