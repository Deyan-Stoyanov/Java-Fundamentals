package hell.entities.engine;

import hell.entities.models.heroes.BaseHero;
import hell.factories.HeroFactory;
import hell.factories.ItemFactory;
import hell.factories.RecipeFactory;
import hell.interfaces.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Engine {
    private Map<String, Hero> heroes;
    private InputReader reader;
    private OutputWriter writer;

    public Engine(Map<String, Hero> heroes, InputReader reader, OutputWriter writer) {
        this.heroes = heroes;
        this.reader = reader;
        this.writer = writer;
    }

    public void run(){
        String command;
        while(!"Quit".equalsIgnoreCase(command = reader.readLine())){
            String[] input = command.split("\\s+");
            String result = "";
            switch (input[0]){
                case "Hero":
                    Hero hero = HeroFactory.createHero(input[2], input[1]);
                    this.heroes.put(hero.getName(), hero);
                    result = String.format("Created %s - %s", input[2], input[1]);
                    break;
                case "Item":
                    String heroName = input[2];
                    Item item = ItemFactory.createItem(input[1], Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]), Integer.parseInt(input[6]), Integer.parseInt(input[7]));
                    this.heroes.get(heroName).addItem(item);
                    result = String.format("Added item - %s to Hero - %s", item.getName(), heroName);
                    break;
                case "Recipe":
                    String heroNameRecipe = input[2];
                    String[] recipeItems = new String[input.length - 7];
                    System.arraycopy(input, 8, recipeItems, 0, input.length - 8);
                    Recipe recipe = RecipeFactory.createRecipe(input[1], Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]), Integer.parseInt(input[6]), Integer.parseInt(input[7]), recipeItems);
                    this.heroes.get(heroNameRecipe).addRecipe(recipe);
                    result = String.format("Added recipe - %s to Hero - %s", recipe.getName(), heroNameRecipe);
                    break;
                case "Inspect":
                    String heroToInspect = input[1];
                    result = (this.heroes.get(heroToInspect).toString());
                    break;
            }
            this.writer.writeLine(result);
        }
        AtomicInteger i = new AtomicInteger();
        StringBuilder sb = new StringBuilder();
        this.heroes.values().stream().sorted((x, y) -> {
            if((y.getStrength() + y.getAgility() + y.getIntelligence()) == (x.getStrength() + x.getAgility() + x.getIntelligence())){
                return (int) ((y.getHitPoints() + y.getDamage()) - (x.getHitPoints() + x.getDamage()));
            }
            return (int) ((y.getStrength() + y.getAgility() + y.getIntelligence()) - (x.getStrength() + x.getAgility() + x.getIntelligence()));
        }).forEach(x -> sb.append(i.incrementAndGet()).append(". ").append(((BaseHero)(x)).resultString()));
        this.writer.writeLine(sb.toString());
    }
}
