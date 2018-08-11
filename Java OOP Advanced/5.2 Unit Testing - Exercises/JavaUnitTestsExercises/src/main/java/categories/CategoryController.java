package categories;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class CategoryController {
    private Map<String, Category> categories;
    private Map<String, User> users;

    public CategoryController() {
        this.categories = new LinkedHashMap<>();
        this.users = new LinkedHashMap<>();
    }

    public void addCategories(Category... categories){
        for (Category category : categories) {
            this.categories.put(category.getName(), category);
        }
    }

    public void addUsers(User... users){
        for (User user : users) {
            this.users.put(user.getName(), user);
        }
    }

    public void removeCategory(String name){
        Category category = this.categories.get(name);
        if(category != null){
            if(!category.getCategories().isEmpty()){
                for (Category category1 : category.getCategories()) {
                    for (User user : category.getUsers()) {
                        category1.addUser(user);
                    }
                }
            }
        }
        categories.remove(name);
    }

    public void moveCategory(String childCategoryName, String oldParentCategoryName, String newParentCategoryName){
        Category oldParent = this.categories.get(oldParentCategoryName);
        Category newParent = this.categories.get(newParentCategoryName);
        Optional<Category> child = oldParent.getCategories().stream().filter(x -> x.getName().equals(childCategoryName)).findFirst();
        child.ifPresent(newParent::addCategory);
        oldParent.removeCategory(childCategoryName);
    }

    public void assignUserToCategory(String userName, String categoryName){
        Category category = categories.get(categoryName);
        category.addUser(users.get(userName));
    }

    public Map<String, Category> getCategories() {
        return Collections.unmodifiableMap(this.categories);
    }

    public Map<String, User> getUsers() {
        return Collections.unmodifiableMap(this.users);
    }
}
