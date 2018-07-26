package app.engine;

import app.entities.arenas.Arena;
import app.entities.characters.abstractions.AntiHero;
import app.entities.characters.abstractions.Hero;
import app.entities.powers.SuperPower;
import app.factories.ArenaFactory;
import app.factories.ComicCharacterFactory;
import app.factories.SuperPowerFactory;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.manager.WarManager;

import java.io.IOException;

public class Engine {
    public static final String END_COMMAND = "WAR_IS_OVER";
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private WarManager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new WarManager();
    }

    public void run() throws IOException {
        String command;
        while (!END_COMMAND.equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "CHECK_CHARACTER":
                    this.writer.printLine(this.manager.checkComicCharacter(tokens[1]));
                    break;
                case "REGISTER_HERO":
                    Hero hero;
                    try {
                        hero = ComicCharacterFactory.createHero(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]));
                        if (hero != null) {
                            writer.printLine(this.manager.addHero(hero));
                        }
                    } catch (IllegalArgumentException ie) {
                        writer.printLine(ie.getMessage());
                    }
                    break;
                case "REGISTER_ANTI_HERO":
                    AntiHero antiHero;
                    try {
                        antiHero = ComicCharacterFactory.createAntiHero(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]));
                        if (antiHero != null) {
                            writer.printLine(this.manager.addAntiHero(antiHero));
                        }
                    } catch (IllegalArgumentException ie) {
                        writer.printLine(ie.getMessage());
                    }
                    break;
                case "BUILD_ARENA":
                    Arena arena = null;
                    try {
                        arena = ArenaFactory.createArena(tokens[1], Integer.parseInt(tokens[2]));
                    } catch (IllegalArgumentException ie) {
                        writer.printLine(ie.getMessage());
                    }
                    if (arena != null) {
                        writer.printLine(this.manager.addArena(arena));
                    }
                    break;
                case "SEND_HERO":
                    writer.printLine(this.manager.addHeroToArena(tokens[1], tokens[2]));
                    break;
                case "SEND_ANTI_HERO":
                    writer.printLine(this.manager.addAntiHeroToArena(tokens[1], tokens[2]));
                    break;
                case "SUPER_POWER":
                    SuperPower superPower = null;
                    try {
                        superPower = SuperPowerFactory.createSuperPower(tokens[1], Double.parseDouble(tokens[2]));
                    } catch (IllegalArgumentException ie) {
                        writer.printLine(ie.getMessage());
                    }
                    if (superPower != null) {
                        writer.printLine(this.manager.loadSuperPowerToPool(superPower));
                    }
                    break;
                case "ASSIGN_POWER":
                    writer.printLine(this.manager.assignSuperPowerToComicCharacter(tokens[1], tokens[2]));
                    break;
                case "UNLEASH":
                    writer.printLine(this.manager.usePowers(tokens[1]));
                    break;
                case "COMICS_WAR":
                    writer.printLine(this.manager.startBattle(tokens[1]));
                    break;
            }
        }
        this.writer.printLine(this.manager.endWar());
    }
}
