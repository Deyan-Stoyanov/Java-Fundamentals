import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Set<Dragon>> army = getDragonStats(reader, n);
        printDragonInfo(army);
    }

    private static void printDragonInfo(Map<String, Set<Dragon>> army) {
        for (Map.Entry<String, Set<Dragon>> colours : army.entrySet()) {

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", colours.getKey(),
                    colours.getValue().stream().mapToDouble(Dragon::getDamage).average().getAsDouble(),
                    colours.getValue().stream().mapToDouble(Dragon::getHealth).average().getAsDouble(),
                    colours.getValue().stream().mapToDouble(Dragon::getArmour).average().getAsDouble());

            Set<Dragon> result = colours.getValue()
                    .stream()
                    .sorted(Comparator.comparing(Dragon::getName))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            for (Dragon dragon : result) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getName(), dragon.getDamage(), dragon.getHealth(), dragon.getArmour());
            }
        }
    }

    private static Map<String, Set<Dragon>> getDragonStats(BufferedReader reader, int n) throws IOException {
        Map<String, Set<Dragon>> army = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String colour = input[0];
            Dragon dragon = createDragon(input);
            if(!army.containsKey(colour)){
                army.put(colour, new LinkedHashSet<>());
            }
            if(army.get(colour).stream().anyMatch(x -> x.getName().equals(dragon.getName()))){
                army.put(colour, army.get(colour).stream().filter(x -> !x.getName().equals(dragon.getName())).collect(Collectors.toCollection(LinkedHashSet::new)));
                army.get(colour).add(dragon);
            }
            army.get(colour).add(dragon);
        }
        return army;
    }

    private static Dragon createDragon(String[] input) {
        Dragon dragon = new Dragon();
        String name = input[1];
        dragon.setName(name);
        if ((input[2].equals("null"))) {
            dragon.setDamageDefaultValue();
        } else {
            dragon.setDamage(Integer.parseInt(input[2]));
        }
        if ((input[3].equals("null"))) {
            dragon.setHealthDefaultValue();
        } else {
            dragon.setHealth(Integer.parseInt(input[3]));
        }
        if ((input[4].equals("null"))) {
            dragon.setArmourDefaultValue();
        } else {
            dragon.setArmour(Integer.parseInt(input[4]));
        }
        return dragon;
    }

    static class Dragon {
        private final static int DAMAGE_DEFAULT_VALUE = 45;
        private final static int HEALTH_DEFAULT_VALUE = 250;
        private final static int ARMOUR_DEFAULT_VALUE = 10;

        private String name;
        private int damage;
        private int health;
        private int armour;

        public Dragon(String name, int damage, int health, int armour) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armour = armour;
        }

        public Dragon() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmour() {
            return armour;
        }

        public void setArmour(int armour) {
            this.armour = armour;
        }

        public static int getDamageDefaultValue() {
            return DAMAGE_DEFAULT_VALUE;
        }

        public static int getHealthDefaultValue() {
            return HEALTH_DEFAULT_VALUE;
        }

        public static int getArmourDefaultValue() {
            return ARMOUR_DEFAULT_VALUE;
        }

        public void setDamageDefaultValue(){
            this.damage = DAMAGE_DEFAULT_VALUE;
        }

        public void setHealthDefaultValue(){
            this.health = HEALTH_DEFAULT_VALUE;
        }

        public void setArmourDefaultValue(){
            this.armour = ARMOUR_DEFAULT_VALUE;
        }
    }
}
