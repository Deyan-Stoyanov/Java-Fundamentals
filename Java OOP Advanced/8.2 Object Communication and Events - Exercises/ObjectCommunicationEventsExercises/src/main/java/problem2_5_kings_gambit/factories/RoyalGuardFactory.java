package problem2_5_kings_gambit.factories;

import problem2_5_kings_gambit.models.RoyalGuard;

public class RoyalGuardFactory {
    public static RoyalGuard createRoyalGuard(String name){
        return new RoyalGuard(name);
    }
}
