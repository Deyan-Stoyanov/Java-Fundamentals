package catrgories;

import categories.Category;
import categories.CategoryController;
import categories.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CategoryTests {
    CategoryController categoryController;

    @Before
    public void init(){
        this.categoryController = new CategoryController();
    }

    @Test
    public void addCategoryTest(){
        Category category = new Category("asd");
        this.categoryController.addCategories(category, Mockito.mock(Category.class));
        Assert.assertEquals(this.categoryController.getCategories().size(), 2);
    }

    @Test
    public void addUserTest(){
        this.categoryController.addUsers(Mockito.mock(User.class));
        Assert.assertEquals(this.categoryController.getUsers().size(), 1);
    }

    @Test
    public void removeCategoryMovesUsersToChild(){
        Category parent = new Category("parent");
        Category child = new Category("child");
        User user = new User("Pesho");
        parent.addUser(user);
        parent.addCategory(child);
        this.categoryController.addCategories(parent, child);
        this.categoryController.removeCategory(parent.getName());
        Assert.assertEquals(this.categoryController.getCategories().get(child.getName()).getUsers().size(), 1);
    }

    @Test
    public void moveCategoryMovesChildrenToNewParent(){
        Category oldParent = new Category("oldParent");
        Category child = new Category("child");
        Category newParent = new Category("newParent");
        oldParent.addCategory(child);
        this.categoryController.addCategories(oldParent, child, newParent);
        this.categoryController.moveCategory("child", "oldParent", "newParent");
        Assert.assertEquals(this.categoryController.getCategories().get(oldParent.getName()).getCategories().size(), 0);
        Assert.assertEquals(this.categoryController.getCategories().get(newParent.getName()).getCategories().size(), 1);
    }

    @Test
    public void assignUserToCategoryAddsAnUserToCategory(){
        Category category = new Category("category");
        User user = new User("Pesho");
        this.categoryController.addCategories(category);
        this.categoryController.addUsers(user);
        this.categoryController.assignUserToCategory(user.getName(), category.getName());
        Assert.assertEquals(categoryController.getCategories().get(category.getName()).getUsers().size(), 1);
    }
}
