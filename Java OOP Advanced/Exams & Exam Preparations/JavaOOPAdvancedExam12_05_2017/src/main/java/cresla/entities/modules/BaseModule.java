package cresla.entities.modules;

import cresla.interfaces.Module;
import cresla.util.Const;

public abstract class BaseModule implements Module {
    private int id;

    protected BaseModule() {
        this.id = ++Const.INITIAL_ID;
    }

    public abstract int getSpecial();

    @Override
    public int getId() {
        return this.id;
    }
}
