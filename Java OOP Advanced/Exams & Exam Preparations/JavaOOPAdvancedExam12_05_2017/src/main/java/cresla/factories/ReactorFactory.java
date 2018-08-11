package cresla.factories;

import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.Reactor;

public final class ReactorFactory {
    public static Reactor createReactor(String type, int param, int capacity){
        switch (type){
            case "Cryo":
                return new CryoReactor(param, capacity);
            default:
                return new HeatReactor(param, capacity);
        }
    }
}
