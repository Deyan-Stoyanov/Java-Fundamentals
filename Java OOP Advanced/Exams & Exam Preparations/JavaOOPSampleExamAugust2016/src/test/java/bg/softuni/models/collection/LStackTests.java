package bg.softuni.models.collection;

import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class LStackTests {
    private Stack<Fragment> stack;
    @Before
    public void init(){
        this.stack = new LStack<>();
    }

    @Test
    public void getSizeReturnsSize(){
        this.stack.push(Mockito.mock(Fragment.class));
        this.stack.push(Mockito.mock(Fragment.class));
        this.stack.push(Mockito.mock(Fragment.class));
        Assert.assertEquals(java.util.Optional.of(3).get(), this.stack.size());
    }

    @Test
    public void peekElement() throws NoSuchFieldException, IllegalAccessException {
        Fragment mockFragment = Mockito.mock(Fragment.class);
        Mockito.when(mockFragment.getName()).thenReturn("Pesho");
        this.stack.push(mockFragment);
        Field field = this.stack.getClass().getDeclaredField("innerList");
        field.setAccessible(true);
        Assert.assertEquals("Pesho", ((LinkedList<Fragment>)field.get(this.stack)).peek().getName());
    }

    @Test
    public void removeElement(){
        this.stack.push(Mockito.mock(Fragment.class));
        this.stack.push(Mockito.mock(Fragment.class));
        this.stack.pop();
        Assert.assertEquals(java.util.Optional.of(1).get(), this.stack.size());
    }

    @Test
    public void isEmpty(){
        Assert.assertTrue(this.stack.isEmpty());
        this.stack.push(Mockito.mock(Fragment.class));
        Assert.assertFalse(this.stack.isEmpty());
    }
}
