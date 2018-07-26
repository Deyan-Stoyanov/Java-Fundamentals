package app.factories;

import app.entities.arenas.Arena;
import app.entities.arenas.ArenaImpl;

public final class ArenaFactory {
    private ArenaFactory (){}
    public static Arena createArena(String name, int capacity){
        return new ArenaImpl(name, capacity);
    }

}
