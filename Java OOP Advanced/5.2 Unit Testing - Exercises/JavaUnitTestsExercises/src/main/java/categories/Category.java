package categories;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Category {
    private String name;
    private Set<User> users;
    private Set<Category> categories;

    public Category(String name) {
        this.name = name;
        this.categories = new LinkedHashSet<>();
        this.users = new LinkedHashSet<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    private void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    private void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }

    public void removeCategory(String name){
        this.setCategories(this.getCategories().stream().filter(x -> !x.getName().equals(name)).collect(Collectors.toCollection(LinkedHashSet::new)));
    }
}
