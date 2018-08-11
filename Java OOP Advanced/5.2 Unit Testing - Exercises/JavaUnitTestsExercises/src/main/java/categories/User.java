package categories;

import java.util.LinkedHashSet;
import java.util.Set;

public class User {
    private String name;
    private Set<Category> categories;

    public User(String name) {
        this.name = name;
        this.categories = new LinkedHashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
