package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.Reactor;
import cresla.util.Const;

public abstract class BaseReactor implements Reactor {
    private int id;
    private ModuleContainer container;

    protected BaseReactor(int capacity) {
        this.id = ++Const.INITIAL_ID;
        this.container = new ModuleContainer(capacity);
    }

    public abstract int getIndex();

    public ModuleContainer getContainer() {
        return this.container;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
