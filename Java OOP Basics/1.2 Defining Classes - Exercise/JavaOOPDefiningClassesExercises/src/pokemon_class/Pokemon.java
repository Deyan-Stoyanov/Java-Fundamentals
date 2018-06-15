package pokemon_class;

public class Pokemon {
    private String name;
    private String element;
    private long health;

    public Pokemon() {
    }

    public Pokemon(String name, String element, long health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }
}
