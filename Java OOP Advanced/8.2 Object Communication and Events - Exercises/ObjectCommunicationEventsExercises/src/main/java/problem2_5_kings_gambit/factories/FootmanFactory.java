package problem2_5_kings_gambit.factories;

import problem2_5_kings_gambit.models.Footman;

public class FootmanFactory {
    public static Footman createFootman(String name){
        return new Footman(name);
    }
}
