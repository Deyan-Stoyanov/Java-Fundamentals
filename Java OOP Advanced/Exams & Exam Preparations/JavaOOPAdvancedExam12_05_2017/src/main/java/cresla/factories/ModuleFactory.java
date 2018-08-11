package cresla.factories;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.interfaces.Module;

public final class ModuleFactory {
    public static Module createModule(String type, int param){
        switch (type){
            case "CryogenRod":
                return new CryogenRod(param);
            case "HeatProcessor":
                return new HeatProcessor(param);
            default:
                return new CooldownSystem(param);
        }
    }
}
