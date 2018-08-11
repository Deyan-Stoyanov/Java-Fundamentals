package problem2_5_kings_gambit.factories;

import problem2_5_kings_gambit.models.King;

public class KingFactory {
    public static King createKing(String name){
        return new King(name);
    }
}
